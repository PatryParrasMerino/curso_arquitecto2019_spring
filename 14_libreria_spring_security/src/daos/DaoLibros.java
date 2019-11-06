package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Libro;


public interface DaoLibros extends JpaRepository<Libro,Integer>{
	@Query("select l From Libro l where l.tema.idTema=?1")
	List<Libro> obtenerLibrosTema(int idTema);
}
