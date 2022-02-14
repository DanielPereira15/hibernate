package hibernate.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RepositorioHibernateCliente implements IRepositorioCliente {

	List<Cliente> listCliente;
	List<Cliente> listClienteProvincia;
	Map<String, Cliente> mapaClientes;
	Map<String, Object> mapaClientesObjetos;

	/**
	 * @param session
	 */
	public RepositorioHibernateCliente() {
	}

	@Override
	public long count() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		long num = (long) session.createQuery("SELECT count(*) FROM Cliente").uniqueResult();
		session.getTransaction().commit();
		return num;

	}

	@Override
	public void deleteById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Object persistenInstance = session.load(Cliente.class, id);
		if (persistenInstance != null) {
			session.delete(persistenInstance);
		}

		session.getTransaction().commit();

	}

	@Override
	public void deleteAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("DELETE FROM Cliente");
		query.executeUpdate();
		session.getTransaction().commit();

	}

	@Override
	public boolean existsById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		boolean existe = false;
		if (session.get(Cliente.class, id) != null) {
			existe = true;
		}
		session.getTransaction().commit();

		return existe;
	}

	@Override
	public Cliente getById(Long id) {

		Cliente clienteBuscado = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		clienteBuscado = session.byId(Cliente.class).load(id);
		session.getTransaction().commit();

		return clienteBuscado;
	}

	@Override
	public List<Cliente> findAll() {

		listCliente = new ArrayList<Cliente>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		listCliente = session.createQuery("Select a FROM Cliente a", Cliente.class).getResultList();
		session.getTransaction().commit();

		return listCliente;
	}

	@Override
	public <S extends Cliente> S save(S entity) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(entity);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Map<String, Cliente> getMapAll() {
		mapaClientes = new HashMap<String, Cliente>();
		listCliente = new ArrayList<Cliente>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		listCliente = session.createQuery("Select a FROM Cliente a", Cliente.class).getResultList();
		for (Cliente cliente : listCliente) {
			mapaClientes.put(cliente.getDni(), cliente);
		}
		session.getTransaction().commit();

		return mapaClientes;
	}

	@Override
	public Cliente getByDNI(String dni) {

		Cliente clienteBuscado = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		clienteBuscado = session.byId(Cliente.class).load(dni);
		session.getTransaction().commit();

		return clienteBuscado;
	}

	@Override
	public List<Cliente> findByProvincia(String provincia) {
		listClienteProvincia = new ArrayList<Cliente>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		listClienteProvincia = session
				.createQuery("Select a FROM Cliente a where provincia='" + provincia + "'", Cliente.class)
				.getResultList();
		session.getTransaction().commit();

		return listClienteProvincia;
	}

}
