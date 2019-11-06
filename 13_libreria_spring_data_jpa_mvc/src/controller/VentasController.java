package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cliente;
import model.Venta;
import service.ServiceClientes;

@Controller
public class VentasController {

	@Autowired
	ServiceClientes serviceClientes;

	@GetMapping(value = "/ventas")
	public String ventas(@SessionAttribute("cliente")Cliente cliente,
											HttpServletRequest request) {
		List<Venta> ventas=serviceClientes.ventasCliente(cliente.getIdCliente());
		request.setAttribute("ventas", ventas);
		return "ventas";
	}
}
