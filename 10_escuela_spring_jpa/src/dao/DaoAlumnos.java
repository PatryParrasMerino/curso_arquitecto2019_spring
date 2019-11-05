package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface DaoAlumnos extends JpaRepository<Alumno, Integer>{
	//void saveAlumno(Alumno al);
	//Alumno findByDni(int dni);
	@Query("Select count(*) From Alumno a Where a.curso.idCurso=?1")
	int alumnosCurso(int idCurso);
}
