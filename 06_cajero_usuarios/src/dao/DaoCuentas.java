package dao;

import java.util.List;

import model.Cuenta;


public interface DaoCuentas {
	Cuenta findCuenta(int numeroCuenta);
	List<Cuenta> findAllCuenta();
	void updateCuenta(Cuenta cuenta);
}
