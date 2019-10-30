package dao;

import java.util.List;

import model.Cliente;


public interface DaoClientes {
	List<Cliente> findClienteByCuenta(int idCuenta);
	void saveCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void removeCliente(int dni);
}
