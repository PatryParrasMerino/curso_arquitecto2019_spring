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

import javabeans.Tema;

@Repository
 public class DaoTemasImpl implements DaoTemas {
	 
	@Autowired
	JdbcTemplate template;
	 
 
    @Override
	public List<Tema> obtenerTemas(){
            String sql="select * from temas";
            return template.query(sql, (rs,fila)->new Tema(rs.getInt("idTema"),rs.getString("tema")));

    }
}
