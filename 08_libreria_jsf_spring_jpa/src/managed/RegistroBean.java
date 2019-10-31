package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoCliente;
import model.Cliente;

@ManagedBean(name="registroBean")
@RequestScoped
public class RegistroBean {
	Cliente cliente;
	String repetirPwd;
	@ManagedProperty("#{daoCliente}")
	DaoCliente daoClientes;
	
	public DaoCliente getDaoClientes() {
		return daoClientes;
	}

	public void setDaoClientes(DaoCliente daoClientes) {
		this.daoClientes = daoClientes;
	}

	public RegistroBean() {
		cliente=new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getRepetirPwd() {
		return repetirPwd;
	}

	public void setRepetirPwd(String repetirPwd) {
		this.repetirPwd = repetirPwd;
	}

	public String registrar(String email) {
		daoClientes.registrar(cliente);
		return "login";
	}
	
}
