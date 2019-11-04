package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface DaoCentro {
	List <Alumno> findAlumnosByCurso(int idCurso);
	List<Curso> findCursoByFecha(Date fechaInicio);
	List<Curso> findCursoByDuracion(int duracion);
	List<Curso> findCursoByDenominacion(String denominacion);
}
