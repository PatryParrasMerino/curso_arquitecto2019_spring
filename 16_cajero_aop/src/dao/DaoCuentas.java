package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cuenta;


public interface DaoCuentas extends JpaRepository<Cuenta,Integer>{
	
	
}
