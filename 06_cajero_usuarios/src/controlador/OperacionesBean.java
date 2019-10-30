package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import service.ServiceCajero;


@ManagedBean
public class OperacionesBean {
	private double cantidad;
	private int destino;
	
	@ManagedProperty("#{sCajero}")
	ServiceCajero cajero;
	
	@ManagedProperty("#{loginBean}")
	LoginBean login;
	

	public ServiceCajero getCajero() {
		return cajero;
	}

	public void setCajero(ServiceCajero cajero) {
		this.cajero = cajero;
	}	

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}
		
	public String ingreso() {
		cajero.ingreso(login.getCuenta(), cantidad);
		return "operaciones";
	}
	public String extraccion() {
		cajero.extraccion(login.getCuenta(), cantidad);
		return "operaciones";
	}
	public String transferencia() {
		cajero.transferencia(login.getCuenta(), destino, cantidad);
		return "operaciones";
	}
}
