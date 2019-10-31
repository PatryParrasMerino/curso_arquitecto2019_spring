package utilidades;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Contexto {
	static ExternalContext econtext;
	static {
		FacesContext fcontext=FacesContext.getCurrentInstance();
		econtext=fcontext.getExternalContext();
	}
	
	public static HttpSession getSession() {
		return (HttpSession)econtext.getSession(true);
	}
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest)econtext.getRequest();
	}
}
