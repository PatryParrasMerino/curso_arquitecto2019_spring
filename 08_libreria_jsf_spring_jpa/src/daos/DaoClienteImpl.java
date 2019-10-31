package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cliente;

/**
 * Session Bean implementation class DaoClienteImpl
 */
@Repository("daoCliente")
public class DaoClienteImpl implements DaoCliente {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	
	@Override
	public boolean autenticar(String user, String pass) {
		
		Query qr=em.createNamedQuery("Cliente.findByUserAndPwd");
		qr.setParameter(1, user);
		qr.setParameter(2, pass);
		return qr.getResultList().size()>0;
	}
	@Transactional
	@Override
	public void registrar(Cliente c) {
		em.persist(c);
	}

	
	@Override
	public Cliente getCliente(String user, String pass) {
		//Query qr=em.createNamedQuery("Cliente.findByUserAndPwd");
		TypedQuery<Cliente> qr=em.createNamedQuery("Cliente.findByUserAndPwd",Cliente.class);
		qr.setParameter(1, user);
		qr.setParameter(2, pass);
		List<Cliente> clientes=qr.getResultList();
		return clientes.size()>0?(Cliente)clientes.get(0):null;
	}
    

}
