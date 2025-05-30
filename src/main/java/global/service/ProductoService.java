/*
 * Fecha: 15/05/2025
 * Descripcion: Desarrollo de una clase para poder mostrar la clase Productos con sus atributos para que sean transformado
 * en una lista cada uno de los atributos de la clase mediante un metodo.*/

package global.service;

import global.models.Categoria;
import global.models.Productos; // Importa la clase Producto del paquete models

import java.sql.SQLException;
import java.util.List; // Importa la interfaz List para manejar listas
import java.util.Optional;

public interface ProductoService {
    List<Productos> listar();

    Optional<Productos> porId(Integer id);

    void guardar(Productos producto );

}

