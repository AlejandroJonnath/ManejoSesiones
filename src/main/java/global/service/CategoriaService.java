package global.service;

import global.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> listar();
    Optional<Categoria> porId(Integer id);
    void guardar(Categoria categoria );
}
