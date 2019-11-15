package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import service.ServicioCajero;

@Controller
public class AccesoController {
	@Autowired
	ServicioCajero sCajero;
	
	@GetMapping (value = "aOperaciones")
	public String verMenuOperaciones(@SessionAttribute("cuentaAutenticada") Cuenta cuentaAuten,HttpSession sesion) {		
		Cuenta cuenta = sCajero.obtenerCuenta(cuentaAuten.getNumeroCuenta());
		sesion.setAttribute("cuentaAutenticada",cuenta);
		return "operaciones";
	}
	
	
	@PostMapping (value = "/login")
	public String validarCuenta(@RequestParam("numCuenta") int numCuenta,HttpSession sesion) {		
		Cuenta cuenta = sCajero.obtenerCuenta(numCuenta);
		if (cuenta != null) {			
			sesion.setAttribute("cuentaAutenticada",cuenta);			
			return "operaciones";
		} else {
			return "login";
		}
	}	
}
