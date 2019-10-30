package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import daos.DaoContactos;
import model.Contacto;


@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	@Autowired
	DaoContactos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Contacto> contactos=dao.recuperarContactos();
		if(contactos.size()>0) {
			request.setAttribute("resultado",1);
			request.setAttribute("contactos",contactos);
		}else {
			request.setAttribute("resultado",0);
		}
	}
}
