package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daos.DaoCliente;
import model.Cliente;

@Controller
public class RegistroController {

	@Autowired
	DaoCliente daoCliente;
	
	@PostMapping(value = "/registrar")
	public String registar(@RequestParam("usuario") String usuario,
						   @RequestParam("password") String password,
						   @RequestParam("email") String email,
						   @RequestParam("telefono") int telefono) {
		Cliente cliente=new Cliente(0,email,password,telefono,usuario);
		daoCliente.registrar(cliente);
		return "login";
	}
	
}
