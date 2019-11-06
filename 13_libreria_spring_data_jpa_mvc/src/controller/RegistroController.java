package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Cliente;
import service.ServiceClientes;

@Controller
public class RegistroController {

	@Autowired
	ServiceClientes serviceClientes;
	
	//es ejecutado con la pulsación del enlace registrese 
	//de la página de login, y prepara el objeto Cliente
	//para recibir los datos de la request
	@GetMapping(value = "toRegistro")
	public String inicio(Model model) { //model es una interfaz de spring que hace el mapeo automatico, guardas cosas
		Cliente cl=new Cliente();
		model.addAttribute("cliente",cl);
		return "registro";
	}
	
	//es ejecutado al producirse el submit del formulario
	//de la página de registro
	@PostMapping(value = "/registrar")
	public String registar(@ModelAttribute("cliente")Cliente cliente) {
		serviceClientes.guardarClientes(cliente);
		return "login";
	}
	
}
