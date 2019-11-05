package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daos.DaoCliente;

@Controller
public class LoginController {

	@Autowired
	DaoCliente daoCliente;
	
	@PostMapping(value = "/login")
	public String login(@RequestParam("user")String user, 
						@RequestParam("pwd")String pwd/*,
						HttpServletRequest request,
						@SessionAttribute("client") Cliente c*/) {
		if(daoCliente.autenticar(user, pwd)) {
			return "bienvenida";
		}else {
			return "error";
		}
	}
	
}
