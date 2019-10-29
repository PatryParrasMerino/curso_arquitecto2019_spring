package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DaoClientes;
import dao.DaoCuentas;
import dao.DaoMovimientos;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class ServiceCajeroImpl
 */
@Stateless
public class ServiceCajeroImpl implements ServiceCajero { //no se sabe que acceso a datos se está usando

	@EJB
	DaoClientes daoClientes;
	@EJB
	DaoCuentas daoCuentas;
	@EJB
	DaoMovimientos daoMovimientos;
	
	@Override
	public Cuenta obtenerCuenta(int IdCuenta) {
		return daoCuentas.findCuenta(IdCuenta);
	}

	@Override
	public void extraccion(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		if(cuenta.getSaldo()<=cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			daoCuentas.updateCuenta(cuenta);
			Movimiento m =new Movimiento(0, cantidad, new Date(), "extracción", cuenta);
			daoMovimientos.saveMovimiento(m);
		}else {
			throw new RuntimeException(); // Se provoca la expección si no hay saldo suficiente para que en transferencia se cancele la transacción
		}
		
	}

	@Override
	public void ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		daoCuentas.updateCuenta(cuenta);
		Movimiento m =new Movimiento(0, cantidad, new Date(), "ingreso", cuenta);
		daoMovimientos.saveMovimiento(m);
	}

	@Override
	public void transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		extraccion(idCuentaOrigen, cantidad);
		ingreso(idCuentaDestino, cantidad);
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {		
		return daoClientes.findClienteByCuenta(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int idCuenta) {
		return daoMovimientos.findMovimientoByCuenta(idCuenta);
	}

	@Override
	public double obtenerSaldo(int idCuenta) {
		Cuenta cuenta=daoCuentas.findCuenta(idCuenta);
		return cuenta.getSaldo();
	}


}
