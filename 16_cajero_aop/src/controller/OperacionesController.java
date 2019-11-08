package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import service.ServiceCajero;
@Controller
public class OperacionesController {
	
	@Autowired
	ServiceCajero cajero;
	
	@PostMapping(value="/doIngresar")	
	public String ingreso(@RequestParam("cantidad") double cantidad,
					@SessionAttribute("cuenta") Cuenta cuenta) {
		cajero.ingreso(cuenta.getNumeroCuenta(), cantidad);
		return "operaciones";
	}
	@PostMapping(value="/doExtraer")	
	public String extraccion(@RequestParam("cantidad") double cantidad,
			@SessionAttribute("cuenta") Cuenta cuenta) {
		cajero.extraccion(cuenta.getNumeroCuenta(), cantidad);
		return "operaciones";
	}
	@PostMapping(value="/doTransferencia")	
	public String transferencia(@RequestParam("cantidad") double cantidad,
			@SessionAttribute("cuenta") Cuenta cuenta,
			@RequestParam("destino") int destino) {
		cajero.transferencia(cuenta.getNumeroCuenta(), destino, cantidad);
		return "operaciones";
	}
}
