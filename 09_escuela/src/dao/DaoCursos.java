package dao;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface DaoCursos {
	List<Curso> findAll();
	Curso findByIdCurso(int idCurso);
	void deleteCurso(int idCurso);
	List<Curso> findByFechaInicio(Date fechaInicio);
	int alumnosCurso(int idCurso);
}
