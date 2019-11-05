package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.DaoCliente;
import daos.DaoVentas;

@Controller
public class VentasController {

	@Autowired
	DaoVentas daoVentas;
	@Autowired
	DaoCliente daoCliente;

	
}
