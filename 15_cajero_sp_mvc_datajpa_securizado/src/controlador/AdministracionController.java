package controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import model.Cliente;
import model.CuentaForm;
import service.ServicioCajero;

@Controller
public class AdministracionController {
	@Autowired
	ServicioCajero sCaj;
	
	@GetMapping (value = "aNuevaCuenta")
	public String iniciarCuenta(Model model,HttpServletRequest req) {
		CuentaForm cuenta = new CuentaForm();
		List<Cliente> clientes = sCaj.obtenerTitulares();
		req.setAttribute("clientes",clientes);
		model.addAttribute("cuenta",cuenta);		
		return "nuevaCuenta";
	}
	
	@PostMapping (value = "/nuevaCuenta")
	public String crearCuenta(@ModelAttribute("cuenta") CuentaForm cuenta) {		
		sCaj.crearCuenta(cuenta);
		return "administracion";
	}	
}
