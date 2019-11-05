package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
@Repository
public class DaoAlumnosImpl implements DaoAlumnos {
	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;
	@Transactional
	@Override
	public void saveAlumno(Alumno al) {
		em.persist(al);
	}

	@Override
	public Alumno findByDni(int dni) {
		return em.find(Alumno.class, dni);
	}

}
