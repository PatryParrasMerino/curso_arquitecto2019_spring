package service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoAlumnos;
import daos.DaoCurso;
import model.Alumno;
import model.Curso;

@Service("sCentro")
public class DaoCentroImpl implements  DaoCentro{

	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;
	
	@Autowired
	DaoCurso daoCurso;
	@Autowired
	DaoAlumnos daoAlumnos;

	@Transactional
	@Override
	public List<Alumno> findAlumnosByCurso(int idCurso) {
		String jpql="Select a from Alumno Where a.idCurso=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, idCurso);
		return (List<Alumno>)qr.getResultList();
	}
	
	@Transactional
	@Override
	public List<Curso> findCursoByFecha(Date fechaInicio) {
		String jpql="Select c from Curso Where c.fecha=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, fechaInicio);
		return (List<Curso>)qr.getResultList();
	}

	@Transactional
	@Override
	public List<Curso> findCursoByDuracion(int duracion){
		String jpql="Select c from Curso Where c.duracion=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, duracion);
		return (List<Curso>)qr.getResultList();
	}

	@Transactional
	@Override
	public List<Curso> findCursoByDenominacion(String denominacion) {
		String jpql="Select c from Curso Where c.denominacion=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, denominacion);
		return (List<Curso>)qr.getResultList();
	}

	
}
