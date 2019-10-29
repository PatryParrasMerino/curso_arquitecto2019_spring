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

import modelo.DaoClientes;
import modelo.DaoTemas;
import modelo.DaoTemasImpl;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this); //para llamar al propio objeto, en este caso el del servlet
		super.init(config);
	}
	
	@Autowired
	DaoClientes dao;
	@Autowired
	DaoTemas gtemas;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean resultado=false;
		if(dao.autenticar(request.getParameter("user"),request.getParameter("pwd"))){
			request.setAttribute("temas", gtemas.obtenerTemas());
			
            resultado=true;
            

		}
		else{
			request.setAttribute("mensaje", "Usuario no registrado");
			
		}
       
        request.setAttribute("resultado",resultado);
	}
	

}
