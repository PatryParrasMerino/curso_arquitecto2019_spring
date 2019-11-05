package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Libro;
import model.Tema;
@Repository("daoLibros")
public class DaoLibrosImpl implements DaoLibros {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	@Override
	public List<Libro> obtenerLibros() {
		TypedQuery<Libro> tq=em.createNamedQuery("Libro.findAll",Libro.class);
		return tq.getResultList();
	}
	@Override
	public List<Libro> obtenerLibrosTema(int idTema) {
		Tema t=em.find(Tema.class, idTema);
		return t.getLibros();
	}
}
