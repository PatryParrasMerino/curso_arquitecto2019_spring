package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cliente;


public interface DaoClientes extends JpaRepository<Cliente,Integer>{
	@Query("select c From Cliente c join c.cuentas t where t.numeroCuenta=?1")
	List<Cliente> findClienteByCuenta(int idCuenta);
	
	
	
}
