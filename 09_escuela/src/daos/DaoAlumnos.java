package daos;

import java.util.List;

import model.Alumno;

public interface DaoAlumnos {
	void saveAlumno(Alumno alumno);
	void updateAlumno(Alumno alumno);
	void removeAlumno(int dni);
}
