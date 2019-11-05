package managed;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.CursoView;
import service.ServiceEscuela;

@ManagedBean
@RequestScoped
public class CursosBean {
	@ManagedProperty("#{serviceEscuela}")
	ServiceEscuela sEscuela;
	private Date fechaSel;
	private List<CursoView> cursos;
	public ServiceEscuela getsEscuela() {
		return sEscuela;
	}
	public void setsEscuela(ServiceEscuela sEscuela) {
		this.sEscuela = sEscuela;
	}
	public Date getFechaSel() {
		return fechaSel;
	}
	public void setFechaSel(Date fechaSel) {
		this.fechaSel = fechaSel;
	}
	public List<CursoView> getCursos() {
		return cursos;
	}
	public void setCursos(List<CursoView> cursos) {
		this.cursos = cursos;
	}
	
	public void recuperarCursos() {
		cursos=sEscuela.obtenerCursosFecha(fechaSel);
	}
	public void borrarCurso(int idCurso) {
		sEscuela.eliminarCurso(idCurso);
		recuperarCursos();
	}
	
	
}
