package modelo;

import java.util.List;

import javabeans.Libro;

public interface DaoVentas {

	void agregarVentas(List<Libro> libros, int idCliente);

}