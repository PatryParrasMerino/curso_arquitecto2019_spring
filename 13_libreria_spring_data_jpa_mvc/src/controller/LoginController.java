package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Cliente;
import service.ServiceClientes;

@Controller
public class LoginController {

	@Autowired
	ServiceClientes serviceClientes;

	@PostMapping(value = "/login")
	public String login(@RequestParam("user") String user, @RequestParam("pwd") String pwd, HttpSession sesion) {
		Cliente cliente = serviceClientes.getCliente(user, pwd);
		if (cliente != null) {
			sesion.setAttribute("cliente", cliente);
			return "menu";
		} else {
			return "error";
		}
	}

}
