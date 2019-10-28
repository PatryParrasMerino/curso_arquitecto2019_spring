package presentacion;


import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daos.DaoContactos;
import model.Contacto;

public class TestContactos {

	/*
	 No funciona poruqe spring aun no se ha iniciado y no es una clase que controle spring
	 
	 @AutoWired
	 static DaoContactos daoContactos	 
	 */
	
	public static void main(String[] args) {
		//iniciar spring
		BeanFactory factory=new ClassPathXmlApplicationContext("springConfig.xml");
		//solicitamos a spring una implementación de DaoContactos
		DaoContactos daoContactos=factory.getBean(DaoContactos.class);
		//DaoContactos daoContactos=factory.getBean("daoContactos",DaoContactos.class); //si hubiese dos clases que implementa la misma interfaz usamos esta opción e indicamos el id
		daoContactos.altaContacto(new Contacto(0, "contacto spring", "spring@gmail.com", 32));
		List<Contacto> contactos=daoContactos.mostrarContactos();
		for(Contacto c:contactos) {
			System.out.println(c.getNombre());
		}
	}
}
