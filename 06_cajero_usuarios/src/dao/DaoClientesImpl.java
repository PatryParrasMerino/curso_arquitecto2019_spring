package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cliente;

/**
 * Session Bean implementation class DaoClientesImpl
 */
@Repository
public class DaoClientesImpl implements DaoClientes {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Cliente> findClienteByCuenta(int idCuenta) {
		String sql="Select clientes.* from clientes as c inner join titulares as t on ";
		sql+="c.dni=t.idCliente where ";
		sql+="t.idCuenta=?";
		return template.query(sql, (rs,fila)->new Cliente(rs.getInt("dni"),
				rs.getString("direccion"),
				rs.getString("nombre"),
				rs.getInt("telefono")),
			idCuenta
		);
	}

	@Override
	public void saveCliente(Cliente cliente) {
        String sql="insert into clientes values(?,?,?,?)";
        template.update(sql,cliente.getDni(),cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono());		
	}

	@Override
	public void updateCliente(Cliente cliente) {
		String sql="Update Clientes set nombre=?, direccion=?, telefono=? where ";
		sql+="dni=?";
		template.update(sql,cliente.getDni(),cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono(),cliente);
		
	}

	@Override
	public void removeCliente(int dni) {
		String sql="delete from clientes where dni=?";
		template.update(sql,dni);		
	}
}
