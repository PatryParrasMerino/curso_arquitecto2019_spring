package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Tema;

public interface DaoTemas extends JpaRepository<Tema,Integer>{
	
}
