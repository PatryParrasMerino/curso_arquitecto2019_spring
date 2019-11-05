package dao;

import model.Alumno;

public interface DaoAlumnos {
	void saveAlumno(Alumno al);
	Alumno findByDni(int dni);
}
