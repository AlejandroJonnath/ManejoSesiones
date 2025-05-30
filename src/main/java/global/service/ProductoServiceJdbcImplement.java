/*
 * Fecha: 15/05/2025
 * Descripcion: Desarrollo de clase para poder mostrar mediante una retornacion la lista de la clase productos
 * el cual acompaña de un objeto donde se desarrolla un arreglo de tipo listado que contendra una cadena de
 * valores en cada atributo para visualizar esos datos.*/
package global.service;
//Importacion de librerias
import global.models.Productos;
import global.repository.ProductosRepositoryJdbcImplement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJdbcImplement implements ProductoService { // Declara la clase que implementa la interfaz ProductoService

    //Creamos una variable de tipo CategoríaRepositoryJdbcImplement
    private ProductosRepositoryJdbcImplement repositoryJdbc;

    //Creamos un constructor donde recibimos la conexión
    public ProductoServiceJdbcImplement(Connection conn) {
        this.repositoryJdbc = new ProductosRepositoryJdbcImplement(conn);
    }

    @Override
    public List<Productos> listar() {

        try{
            return repositoryJdbc.listar();
        }catch(SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }


    @Override
    public Optional<Productos> porId(Integer id) {
        try{
            return Optional.ofNullable(repositoryJdbc.porId(id));
        }catch(SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void guardar(Productos producto) {
        try {
            repositoryJdbc.guardar(producto);
        }catch ( SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(),throwables.getCause());
        }
    }
}






