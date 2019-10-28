package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javabeans.Cliente;
import modelo.DaoClientes;



@WebServlet("/RegistroAction")
public class RegistroAction extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); //para llamar al propio objeto, en este caso el del servlet
		super.init(config);
	}
	
	@Autowired
	DaoClientes dao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                Cliente c=new Cliente(0,request.getParameter("usuario"),
                request.getParameter("password"),
                        request.getParameter("email"),
                        Integer.parseInt(request.getParameter("telefono")));
		dao.registrar(c);
		
		
	}

}
