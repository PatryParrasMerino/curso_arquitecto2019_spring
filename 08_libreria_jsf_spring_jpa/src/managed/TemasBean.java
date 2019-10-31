package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoTemas;
import model.Tema;

@ManagedBean
@RequestScoped
public class TemasBean {
	@ManagedProperty("#{daoTemas}")
	DaoTemas daoTemas;
	private List<Tema> temas;
	private int temaSel;
	
	public DaoTemas getDaoTemas() {
		return daoTemas;
	}

	public void setDaoTemas(DaoTemas daoTemas) {
		this.daoTemas = daoTemas;
	}

	@PostConstruct
	public void inicio() {
		temas=daoTemas.obtenerTemas();
	}
	
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	public int getTemaSel() {
		return temaSel;
	}
	public void setTemaSel(int temaSel) {
		this.temaSel = temaSel;
	}
	//método controlador de acción
	/*public String libros() {
		return "libros";
	}*/
	
}
