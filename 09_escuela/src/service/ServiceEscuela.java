package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;
import model.CursoView;

public interface ServiceEscuela {
	void altaAlumno(Alumno al, int idCurso);
	void eliminarCurso(int idCurso);
	List<CursoView> obtenerCursosFecha(Date fecha);
	List<Curso> obtenerCursos();
}
