package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoAlumnos;
import daos.DaoCurso;
import service.DaoCentro;

@ManagedBean(name="cursoBean")
@RequestScoped
public class CursoBean {

	@ManagedProperty("#{daoAlumnos}")
	DaoAlumnos daoAlumnos;
	@ManagedProperty("#{daoCurso}")
	DaoCurso daoCurso;
	@ManagedProperty("#{daoCentro}")
	DaoCentro daoCentro;
	public DaoAlumnos getDaoAlumnos() {
		return daoAlumnos;
	}
	public void setDaoAlumnos(DaoAlumnos daoAlumnos) {
		this.daoAlumnos = daoAlumnos;
	}
	public DaoCurso getDaoCurso() {
		return daoCurso;
	}
	public void setDaoCurso(DaoCurso daoCurso) {
		this.daoCurso = daoCurso;
	}
	public DaoCentro getDaoCentro() {
		return daoCentro;
	}
	public void setDaoCentro(DaoCentro daoCentro) {
		this.daoCentro = daoCentro;
	}
	
	
}
