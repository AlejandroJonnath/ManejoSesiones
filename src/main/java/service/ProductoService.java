/*
 * Fecha: 15/05/2025
 * Descripcion: Desarrollo de una clase para poder mostrar la clase Productos con sus atributos para que sean transformado
 * en una lista cada uno de los atributos de la clase mediante un metodo.*/

package service;

import models.Productos; // Importa la clase Producto del paquete models
import java.util.List; // Importa la interfaz List para manejar listas

public interface ProductoService { // Declara la interfaz ProductoService
    List<Productos> listar(); // Método abstracto que retorna una lista de productos
}

