package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.DaoLibros;

@Controller
public class LibrosController {

	@Autowired
	DaoLibros daoLibros;
	

	
}
