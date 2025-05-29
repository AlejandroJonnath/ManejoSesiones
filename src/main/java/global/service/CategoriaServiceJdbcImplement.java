package global.service;

import com.google.protobuf.ServiceException;
import global.models.Categoria;
import global.repository.CategoriaRepositoryJdbcImplement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaServiceJdbcImplement implements CategoriaService {

    //Creamos una variable de tipo CategoríaRepositoryJdbcImplement
    private CategoriaRepositoryJdbcImplement repositoryJdbc;

    //Creamos un constructor donde recibimos la conexión
    public CategoriaServiceJdbcImplement(Connection conn) {
        //instaciamos el repostitoryJdvc a un objeto que llame todos los métodos que tiene conn
        this.repositoryJdbc = new CategoriaRepositoryJdbcImplement(conn);
    }

    @Override
    public List<Categoria> listar() {
        try{
            return repositoryJdbc.listar();
        }catch(SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porId(Integer id) {
        try{
            return Optional.ofNullable(repositoryJdbc.porId(id));
        }catch(SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void guardar (Categoria categoria){
        try {
            repositoryJdbc.guardar(categoria);
        }catch ( SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(),throwables.getCause());
        }
    }
}
