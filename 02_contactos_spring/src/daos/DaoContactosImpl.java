package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Contacto;

@Repository(value = "daoContactos")

public class DaoContactosImpl implements DaoContactos {
	
	@Autowired
	DataSource ds;

	
	@Override
	public void altaContacto() {
		try(Connection con=ds.getConnection();){
			String sql="insert into contactos(nombre,email,edad) values(";
			sql+="'jdbc','jdbc@gmail.com',50)";
			Statement st=con.createStatement();
			st.execute(sql);			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void altaContacto(Contacto contacto) {
		String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
		try(Connection con=ds.getConnection();
				PreparedStatement prep=con.prepareStatement(sql);){	
			prep.setString(1,contacto.getNombre());
			prep.setString(2,contacto.getEmail());
			prep.setInt(3,contacto.getEdad());
			prep.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	@Override
	public List<Contacto> recuperarContactos(){
		List<Contacto> contactos=new ArrayList<>();
		String sql="select * from contactos";
		try(Connection con=ds.getConnection();
				PreparedStatement prep=con.prepareStatement(sql);
				ResultSet rs=prep.executeQuery();){
			while(rs.next()) {
				contactos.add(new Contacto(rs.getInt("idContacto"),
						rs.getString("nombre"),
						rs.getString("email"),
						rs.getInt("edad")));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
	
	@Override
	public void eliminarContacto(int id) {
		String sql="delete from contactos where idContacto=?";
		try(Connection con=ds.getConnection();
			PreparedStatement prep=con.prepareStatement(sql);){
				prep.setInt(1,id);
				prep.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
