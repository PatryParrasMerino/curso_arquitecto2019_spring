package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Cuenta;
import service.ServiceCajero;

@Controller
public class LoginController {
	@Autowired
	ServiceCajero cajero;
	@PostMapping(value="/doLogin")
	public String entrar(@RequestParam("numeroCuenta") int numeroCuenta,HttpSession sesion) {
		Cuenta cuenta=cajero.obtenerCuenta(numeroCuenta);
		if(cuenta!=null) {
			sesion.setAttribute("cuenta", cuenta);
			return "operaciones";
		}else {
			return "login";
		}
	}
}
