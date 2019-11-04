package daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Curso;

@Repository("daoCursos")
public class DaoCursoImpl implements  DaoCurso{

	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;

	@Override
	public void removeCurso(int idCurso) {
		Curso curso=em.find(Curso.class, idCurso);
		if(curso!=null) {
			em.remove(curso);
		}
		
	}

	@Override
	public List<Curso> findCurso(int idCurso) {
		String jpql="Select c from Curso Where c.idCurso=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, idCurso);
		return (List<Curso>)qr.getResultList();
	}
	
}
