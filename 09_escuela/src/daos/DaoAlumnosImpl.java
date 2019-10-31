package daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository("daoAlumnos")
public class DaoAlumnosImpl implements  DaoAlumnos{

	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;

	@Override
	public void saveAlumno(Alumno alumno) {
		em.persist(alumno);
		
	}

	@Override
	public void updateAlumno(Alumno alumno) {
		em.merge(alumno);
		
	}

	@Transactional
	@Override
	public void removeAlumno(int dni) {
		Alumno alumno=em.find(Alumno.class, dni);
		if(alumno!=null) {
			em.remove(alumno);
		}
		
	}

}
