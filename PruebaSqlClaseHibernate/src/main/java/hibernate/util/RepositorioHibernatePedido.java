package hibernate.util;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class RepositorioHibernatePedido implements IRepositorioPedido {

	Session session;

	/**
	 * @param session
	 */
	public RepositorioHibernatePedido() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	@Override
	public long count() {
		return 0;

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pedido getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Pedido> S save(S entity) {

		session.save(entity);

		return null;
	}

	@Override
	public List<Pedido> findByFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
