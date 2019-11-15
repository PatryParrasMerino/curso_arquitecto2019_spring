package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface DaoClientes extends JpaRepository<Cliente,Integer> {
	public List<Cliente> findAllByCuentas(int idCuenta);
}
