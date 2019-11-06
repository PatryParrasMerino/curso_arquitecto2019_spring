package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.ServiceLibros;

@Controller
public class TemasController {

	@Autowired
	ServiceLibros serviceLibros;
	
	//RequestMaping tanto con get como con post pasa por aquí,le da igual si es get o post
	@RequestMapping(value = "/temas",method = {RequestMethod.GET, RequestMethod.POST}) //indicas para que métodos lo quieres
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
		return "forward:/temas";//forzar otra petición a temas, para pasar por le contrador de acción		
	}
	
}
