package global.models;

public class Categoria {
    //JavaBeans
    //1) Todas las variables deben estar encapsulados

    private int idCategoria;
    private String nombre;
    private String descripcion;
    private int condicion;

    //2) Generamos un objeto vacío porque no recibe parametros
    public Categoria(){

    }

    public Categoria(int idCategoria, String nombre, String descripcion, int condicion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.condicion = condicion;
    }

    //Setters y Getters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCondicion() {
        return condicion;
    }
    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

}
