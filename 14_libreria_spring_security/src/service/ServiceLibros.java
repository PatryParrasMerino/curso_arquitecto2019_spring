package service;

import java.util.List;

import model.Libro;
import model.Tema;

public interface ServiceLibros {
	List<Tema> recuperarTemas();
	List<Libro> recuperarLibros();
	List<Libro> recuperarLibrosPorTema(int idTema);
}
