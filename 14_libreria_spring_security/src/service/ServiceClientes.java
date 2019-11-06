package service;

import java.util.List;

import model.Cliente;
import model.Venta;

public interface ServiceClientes {
	Cliente getCliente(String user, String pass);
	List<Venta> ventasCliente(int idCliente);
	void guardarClientes(Cliente cliente);
}
