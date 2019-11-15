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
public class OperacionesController {
	@Autowired
	ServicioCajero sCajero;
	
	@PostMapping(value = "/ingreso")
	public String ingresar(@SessionAttribute("cuentaAutenticada") Cuenta cuenta,
						   @RequestParam("cantidad") String cantidad,
						   HttpSession sesion) {
		sCajero.ingresar(cuenta.getNumeroCuenta(),Double.parseDouble(cantidad));
		Cuenta cuentaActualizada = sCajero.obtenerCuenta(cuenta.getNumeroCuenta());		
		sesion.setAttribute("cuentaAutenticada",cuentaActualizada);
		return "operaciones";
	}
	
	@PostMapping(value = "/extraccion")
	public String extraer(@SessionAttribute("cuentaAutenticada") Cuenta cuenta,
						  @RequestParam("cantidad") String cantidad,
						   HttpSession sesion) {
		sCajero.extraer(cuenta.getNumeroCuenta(),Double.parseDouble(cantidad));
		Cuenta cuentaActualizada = sCajero.obtenerCuenta(cuenta.getNumeroCuenta());		
		sesion.setAttribute("cuentaAutenticada",cuentaActualizada);
		return "operaciones";
	}
	
	
	@PostMapping (value = "/transferencia")
	public String transferir(@RequestParam("cuentaDestino") int numCuentaDestino,
			   				 @RequestParam("cantidad") String cantidad,
   							 @SessionAttribute("cuentaAutenticada") Cuenta cuenta,
   							 HttpSession sesion) {
		sCajero.transferir(cuenta.getNumeroCuenta(), numCuentaDestino,Double.parseDouble(cantidad));
		Cuenta cuentaActualizada = sCajero.obtenerCuenta(cuenta.getNumeroCuenta());		
		sesion.setAttribute("cuentaAutenticada",cuentaActualizada);
		return "operaciones";
	}
	
	@GetMapping (value = "aCambioDeCuenta")
	public String cambiarDeCuenta(@RequestParam("cuenta") int numCuenta,
								  HttpSession sesion) {
		Cuenta cuenta = sCajero.obtenerCuenta(numCuenta);
		sesion.setAttribute("cuentaAutenticada",cuenta);
		return "operaciones";
	}
}
