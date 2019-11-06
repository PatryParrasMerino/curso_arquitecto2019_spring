package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.ServiceLibros;

@Controller
public class TemasControllerOTRASOLUCION {

	@Autowired
	ServiceLibros serviceLibros;
	
	
	@GetMapping(value = "/temas") 
	public String recuperarTemas(HttpServletRequest request) {
		request.setAttribute("temas", serviceLibros.recuperarTemas());
		return "temas";
	}
	
	@PostMapping(value = "/libros")
	public String obtenerLibros(@RequestParam("tema") int idTema,
								HttpServletRequest request) {
		if(idTema==0) {
			request.setAttribute("libros", serviceLibros.recuperarLibros());
		}else {
			request.setAttribute("libros", serviceLibros.recuperarLibrosPorTema(idTema));
		}
		request.setAttribute("temas", serviceLibros.recuperarTemas()); //Esto es otra solución para no perder los temas
		return "temas";
	}
	
}
