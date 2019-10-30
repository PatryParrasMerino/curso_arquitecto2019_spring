package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoClientes;
import dao.DaoCuentas;
import dao.DaoMovimientos;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class ServiceCajeroImpl
 */
@Service("sCajero")
public class ServiceCajeroImpl implements ServiceCajero { //no se sabe que acceso a datos se está usando

	@Autowired
	DaoClientes daoClientes;
	@Autowired
	DaoCuentas daoCuentas;
	@Autowired
	DaoMovimientos daoMovimientos;

	
	@Override
	public Cuenta obtenerCuenta(int IdCuenta) {
		return daoCuentas.findCuenta(IdCuenta);
	}

	@Transactional
	@Override
	public void extraccion(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		if(cuenta.getSaldo()>=cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			daoCuentas.updateCuenta(cuenta);
			Movimiento m =new Movimiento(0, cantidad, new Date(), "extracción", idCuenta);
			daoMovimientos.saveMovimiento(m);
		}else {
			throw new RuntimeException(); // Se provoca la expección si no hay saldo suficiente para que en transferencia se cancele la transacción
		}
		
	}

	@Transactional
	@Override
	public void ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		daoCuentas.updateCuenta(cuenta);
		Movimiento m =new Movimiento(0, cantidad, new Date(), "ingreso", idCuenta);
		daoMovimientos.saveMovimiento(m);
	}

	@Transactional
	@Override
	public void transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuentaOrigen);
		if(cuenta.getSaldo()>=cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			daoCuentas.updateCuenta(cuenta);
			Movimiento m =new Movimiento(0, cantidad, new Date(), "transferencia", idCuentaOrigen);
			daoMovimientos.saveMovimiento(m);
		}else {
			throw new RuntimeException(); // Se provoca la expección si no hay saldo suficiente para que en transferencia se cancele la transacción
		}
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
