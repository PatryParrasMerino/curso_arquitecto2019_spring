package dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Cuenta;
import model.Movimiento;

public interface DaoMovimientos extends JpaRepository<Movimiento,Integer> {	
	public List<Movimiento> findAllByCuenta(Cuenta cuenta);
}
