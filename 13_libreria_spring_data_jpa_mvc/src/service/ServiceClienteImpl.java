package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoCliente;
import daos.DaoVentas;
import model.Cliente;
import model.Venta;

@Service
public class ServiceClienteImpl implements ServiceClientes {

	@Autowired
	DaoCliente daoCliente;
	@Autowired
	DaoVentas daoVentas;
	
	@Override
	public Cliente getCliente(String user, String pass) {
		return daoCliente.findByUsuarioAndPassword(user, pass);
	}

	@Override
	public List<Venta> ventasCliente(int idCliente) {
		return daoVentas.recuperarVentasCliente(idCliente);
	}

	@Override
	public void guardarClientes(Cliente cliente) {
		if(!daoCliente.existsById(cliente.getIdCliente())) {
			daoCliente.save(cliente);
		}
	}

}
