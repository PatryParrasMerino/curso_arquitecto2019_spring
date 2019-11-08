package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import service.ServiceCajero;
@Controller
public class MovimientosController {
	
	@Autowired
	ServiceCajero cajero;
	@GetMapping(value="/doMovimientos")
	public String movimientos(@SessionAttribute("cuenta") Cuenta cuenta,
			HttpServletRequest request) {
		request.setAttribute("movimientos", cajero.obtenerMovimientos(cuenta.getNumeroCuenta()));
		request.setAttribute("saldo", cajero.obtenerSaldo(cuenta.getNumeroCuenta()));
		return "movimientos";
	}
}
