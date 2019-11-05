package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Alumno;
import model.Curso;
import service.ServiceEscuela;

@ManagedBean
@RequestScoped
public class AltaAlumnosBean {
	@ManagedProperty("#{serviceEscuela}")
	ServiceEscuela sEscuela;
	List<Curso> cursos;
	Alumno alumno;
	int idCursoSel;
	@PostConstruct()
	public void inicio() {
		alumno=new Alumno();
		cursos=sEscuela.obtenerCursos();
	}
	public ServiceEscuela getsEscuela() {
		return sEscuela;
	}
	public void setsEscuela(ServiceEscuela sEscuela) {
		this.sEscuela = sEscuela;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public int getIdCursoSel() {
		return idCursoSel;
	}
	public void setIdCursoSel(int idCursoSel) {
		this.idCursoSel = idCursoSel;
	}
	public String registrar() {
		sEscuela.altaAlumno(alumno, idCursoSel);
		return "menu";
	}
}
