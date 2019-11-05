package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;


public interface DaoCliente extends JpaRepository<Cliente,Integer>{
	

	
	
	Cliente findByUsuarioAndPassword(String user, String pass);
}
