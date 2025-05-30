package global.repository;

import global.models.Categoria;
import global.models.Productos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosRepositoryJdbcImplement implements Repository<Productos> {
    //1) Creamos una variable donde vamos a guardar la conexión
    private Connection conn;

    //2) Genero un constructor que recibe la conexión
    public ProductosRepositoryJdbcImplement(Connection conn) {
        //va a traer la conexión y la guardará en el conn que está en la parte derecha del igual
        this.conn = conn;
    }

    @Override
    public List<Productos> listar() throws SQLException {
        List<Productos> productos = new ArrayList<>(); //Creamos un nuevo objeto de tipo categoría
        try(Statement stmt = conn.createStatement(); //Esto me permite interactuar con la bdd
            ResultSet rs = stmt.executeQuery("select * from articulo")){ //Me permite realizar la consulta
            while (rs.next()) { //mientas lo siga recorriendo
                Productos p = getProductos(rs);

                productos.add(p);
            }
        }
        return productos;
    }



    @Override
    public Productos porId(Integer id) throws SQLException {
        Productos productos = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM articulo WHERE idArticulo = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {  // Muy importante para evitar errores
                    productos = getProductos(rs);
                }
            }
        }
        return productos;
    }

    @Override
    public void guardar(Productos productos) throws SQLException {
        String sql;
        boolean esUpdate = productos.getIdArticulo() != null && productos.getIdArticulo() > 0;

        if (esUpdate) {
            sql = "UPDATE articulo SET codigo = ?, nombre = ?, stock = ?, descripcion = ?, imagen = ? WHERE idArticulo = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, productos.getCodigo());
                stmt.setString(2, productos.getNombre());
                stmt.setInt(3, productos.getStock());
                stmt.setString(4, productos.getDescripcion());
                stmt.setString(5, productos.getImagen());
                stmt.setInt(7, productos.getIdArticulo());
                stmt.executeUpdate();
            }
        } else {
            sql = "INSERT INTO articulo (codigo, nombre, stock, descripcion, imagen, condicion) VALUES (?, ?, ?, ?, ?, 1)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, productos.getCodigo());
                stmt.setString(2, productos.getNombre());
                stmt.setInt(3, productos.getStock());
                stmt.setString(4, productos.getDescripcion());
                stmt.setString(5, productos.getImagen());
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql = "UPDATE articulo SET condicion = 0 WHERE idArticulo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    private static Productos getProductos(ResultSet rs) throws SQLException {
        Productos p = new Productos(); //Creo un nuevo objeto vació de la clase categoría porque lo lleno con lo de abajo
        p.setIdArticulo(rs.getInt("idArticulo"));
        p.setIdCategoria(rs.getInt("idCategoria"));
        p.setCodigo(rs.getString("codigo"));
        p.setNombre(rs.getString("nombre")); //Settear el nombre del método getString del javaBeans
        p.setStock(rs.getInt("stock"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setImagen(rs.getString("imagen"));
        p.setCondicion(rs.getInt("condicion"));
        return p;
    }
}
