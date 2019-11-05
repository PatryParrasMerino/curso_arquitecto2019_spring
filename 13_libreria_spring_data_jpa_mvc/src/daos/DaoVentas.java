package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Venta;


public interface DaoVentas extends JpaRepository<Venta,Integer>{
	@Query("Select v From Venta v Where v.cliente.idCliente=?1")
	List<Venta> recuperarVentasCliente(int idCliente);
	
}
