package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;
import utilidades.Contexto;

@ManagedBean(name="librosBean")
@RequestScoped
public class LibrosBean {
	@ManagedProperty("#{daoLibros}")
	DaoLibros daoLibros;
	
	
	public DaoLibros getDaoLibros() {
		return daoLibros;
	}

	public void setDaoLibros(DaoLibros daoLibros) {
		this.daoLibros = daoLibros;
	}


	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;
	
	private List<Libro> libros;
	@PostConstruct
	public void creado() {
		//obtenci�n del usuario a trav�s del contexto
		String usuario;
		LoginBean loginBean=(LoginBean)Contexto.getSession().getAttribute("loginBean");
		usuario=loginBean.getUsuario();		
	}

	public List<Libro> getLibros() {
		//recuperamos el tema y despu�s los libros asociados
		//cuando se solicten los libros, no al principio
		if(temasBean.getTemaSel()==0) {
			libros=daoLibros.obtenerLibros();
		}else {
			libros=daoLibros.obtenerLibrosTema(temasBean.getTemaSel());
		}
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public TemasBean getTemasBean() {
		return temasBean;
	}

	public void setTemasBean(TemasBean temasBean) {
		this.temasBean = temasBean;
	}
	
	
	//controlador de acci�n
	public String finSesion() {
		Contexto.getSession().invalidate();
		return "validado";
	}
	
}
