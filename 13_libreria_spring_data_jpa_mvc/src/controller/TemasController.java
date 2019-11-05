package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daos.DaoTemas;
import model.Tema;

@Controller
public class TemasController {

	@Autowired
	DaoTemas daoTemas;
	
	@PostMapping(value = "/temas")
	public String temas(@RequestParam("temas")List<Tema> temas) {
		daoTemas.obtenerTemas();
	}
	
}
