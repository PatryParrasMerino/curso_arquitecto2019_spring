package controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Movimiento;
import service.ServiceCajero;


@ManagedBean
public class MovimientosBean {
	
	private double saldo;
	private List<Movimiento> movimientos;
	
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

	public double getSaldo() {
		saldo=cajero.obtenerSaldo(login.getCuenta());
		return saldo;
	}	

	public List<Movimiento> getMovimientos() {
		
		movimientos=cajero.obtenerMovimientos(login.getCuenta());
		return movimientos;
	}	

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}
	
	
}
