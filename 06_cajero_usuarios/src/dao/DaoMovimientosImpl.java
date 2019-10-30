package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Movimiento;

/**
 * Session Bean implementation class DaoMovimientosImpl
 */
@Repository
public class DaoMovimientosImpl implements DaoMovimientos {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Movimiento> findMovimientoByCuenta(int idCuenta) {
		String sql="Select movimientos.* from movimientos  ";
		sql+="where idCuenta=?";
		
		return template.query(sql, (rs,fila)->new Movimiento(rs.getInt("idMovimiento"),
				rs.getDouble("cantidad"),
				rs.getDate("fecha"),
				rs.getString("operacion"),
				idCuenta
				),
			idCuenta
		);
	}

	@Override
	public void saveMovimiento(Movimiento m) {
		String sql ="insert into movimientos (cantidad,fecha,operacion,idCuenta) ";
		sql+="values(?,?,?,?)";
		template.update(sql,m.getCantidad(),m.getFecha(),m.getOperacion(),m.getIdCuenta());	
	}
}
