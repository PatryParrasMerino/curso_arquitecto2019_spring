package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoLibros;
import daos.DaoTemas;
import model.Libro;
import model.Tema;

@Service
public class SericeLibrosImpl implements ServiceLibros {

	@Autowired
	DaoLibros daoLibros;
	@Autowired
	DaoTemas daoTemas;
	
	@Override
	public List<Tema> recuperarTemas() {
		return daoTemas.findAll();
	}

	@Override
	public List<Libro> recuperarLibros() {
		return daoLibros.findAll();
	}

	@Override
	public List<Libro> recuperarLibrosPorTema(int idTema) {
		return daoLibros.obtenerLibrosTema(idTema);
	}

}
