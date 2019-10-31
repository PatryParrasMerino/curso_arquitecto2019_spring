package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoCurso;
import model.Alumno;

@Service("sCentro")
public class DaoCentroImpl implements  DaoCentro{

	@PersistenceContext(unitName = "escuelaPU")
	EntityManager em;
	
	@Autowired
	DaoCurso daoCurso;

	@Transactional
	@Override
	public List<Alumno> findAlumnoByCurso(int idCurso) {
		
	}


	
}
