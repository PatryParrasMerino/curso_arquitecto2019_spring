package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;


public interface DaoMovimientos extends JpaRepository<Movimiento,Integer>{
	@Query("select m from Movimiento m where m.cuenta.numeroCuenta=?1")
	List<Movimiento> findMovimientoByIdCuenta(int idCuenta);
	
}