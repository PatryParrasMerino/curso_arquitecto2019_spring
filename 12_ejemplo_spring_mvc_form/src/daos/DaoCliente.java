package daos;

import model.Cliente;


public interface DaoCliente {
	boolean autenticar(String user, String pass);

	void registrar(Cliente c);
	
	Cliente getCliente(String user, String pass);
}
