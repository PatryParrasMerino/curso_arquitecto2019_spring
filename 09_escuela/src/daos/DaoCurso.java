package daos;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface DaoCurso {
	List<Curso> findCursoByFecha(Date fechaInicio);
	List<Curso> findCurso(int idCurso);
	void removeCurso(int idCurso);
}
