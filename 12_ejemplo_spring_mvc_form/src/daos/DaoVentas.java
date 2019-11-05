package daos;

import java.util.List;

import model.Venta;


public interface DaoVentas {
	List<Venta> recuperarVentasCliente(int idCliente);
	void registrarVenta(Venta venta);
}
