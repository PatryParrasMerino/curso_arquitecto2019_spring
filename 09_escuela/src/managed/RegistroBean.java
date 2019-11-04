package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoAlumnos;
import model.Alumno;
import service.DaoCentro;


@ManagedBean(name="registroBean")
@RequestScoped
public class RegistroBean {

	@ManagedProperty("#{daoAlumnos}")
	DaoAlumnos daoAlumnos;
	@ManagedProperty("#{daoCentro}")
	DaoCentro daoCentro;
	
	Alumno alumno;
	
	public DaoAlumnos getDaoAlumnos() {
		return daoAlumnos;
	}
	public void setDaoAlumnos(DaoAlumnos daoAlumnos) {
		this.daoAlumnos = daoAlumnos;
	}
	public DaoCentro getDaoCentro() {
		return daoCentro;
	}
	public void setDaoCentro(DaoCentro daoCentro) {
		this.daoCentro = daoCentro;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
}
