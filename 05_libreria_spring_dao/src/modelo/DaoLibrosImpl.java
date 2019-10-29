/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javabeans.Libro;

@Repository
 public class DaoLibrosImpl implements DaoLibros {
	 
	@Autowired
	JdbcTemplate template;
    
    @Override
	public List<Libro> recuperarLibros(){                       
        String sql="select * from libros";
        return template.query(sql, (rs,fila)->new Libro(rs.getInt("isbn"),
								                        rs.getString("titulo"),
								                        rs.getString("autor"),
								                        rs.getDouble("precio"),
								                        rs.getInt("paginas"),
								                        rs.getInt("idTema")));
   
    }
    @Override
	public List<Libro> recuperarLibros(int idTema){                      
        	String sql="select * from libros where idTema=?";
        	//query(String sql, RowMapper<T> rowMapper, Object... args)
			return template.query(sql, (rs,fila)->new Libro(rs.getInt("isbn"),
									                        rs.getString("titulo"),
									                        rs.getString("autor"),
									                        rs.getDouble("precio"),
									                        rs.getInt("paginas"),
									                        rs.getInt("idTema")),
												idTema
												); 
    }
    
    
}
