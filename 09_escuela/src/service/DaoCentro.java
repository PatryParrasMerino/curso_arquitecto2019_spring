package service;

import java.util.List;

import model.Alumno;

public interface DaoCentro {
	List <Alumno> findAlumnoByCurso(int idCurso);
}
