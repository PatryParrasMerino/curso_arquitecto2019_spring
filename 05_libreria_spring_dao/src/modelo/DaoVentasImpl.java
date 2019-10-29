package modelo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javabeans.Libro;

@Repository
public class DaoVentasImpl implements DaoVentas {
	 
	@Autowired
	JdbcTemplate template;

	@Transactional(propagation = Propagation.REQUIRED) //aplicas un objeto, no lo estás inyectando
	@Override
	public void agregarVentas(List<Libro> libros, int idCliente) {
		String sql="Insert into ventas(idCliente,idLibro,fecha) values(?,?,?)";		
		Date fecha=new Date();
		for (Libro lib : libros) {
			template.update(sql,idCliente,lib.getIsbn(),fecha);
		}
	}
}

