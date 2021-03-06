package controller;

import java.io.IOException;

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

/**
 * Servlet implementation class Alta
 */
@WebServlet(urlPatterns= {"/AltaAction"})
public class AltaAction extends HttpServlet {
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); //para llamar al propio objeto, en este caso el del servlet
		super.init(config);
	}
	
	@Autowired
	DaoContactos dao;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contacto contacto=new Contacto(0,
				request.getParameter("nombre"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("edad")));
		dao.altaContacto(contacto);
		
	}

}
