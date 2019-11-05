package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;
@Repository
public class DaoCursosImpl implements DaoCursos {
	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;
	@Override
	public List<Curso> findAll() {
		TypedQuery<Curso> tquery=em.createNamedQuery("Curso.findAll",Curso.class);
		return tquery.getResultList();
	}
	@Override
	public Curso findByIdCurso(int idCurso) {
		return em.find(Curso.class, idCurso);
	}
	@Transactional
	@Override
	public void deleteCurso(int idCurso) {
		Curso curso=findByIdCurso(idCurso);
		if(curso!=null) {
			em.remove(curso);
		}
	}
	@Override
	public List<Curso> findByFechaInicio(Date fechaInicio) {
		String jpql="select c From Curso c where ";
		jpql+="c.fechaInicio>=?1";
		TypedQuery<Curso> tquery=em.createQuery(jpql,Curso.class);
		tquery.setParameter(1, fechaInicio);
		return tquery.getResultList();
	}
	@Override
	public int alumnosCurso(int idCurso) {
		Curso curso=findByIdCurso(idCurso);
		return curso.getAlumnos().size();
	}

}
