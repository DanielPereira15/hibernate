package hibernate.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;

public class Test {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
				System.out.println("ok");

		}
		catch (Exception e) {

		e.printStackTrace();
	} finally {
	//	HibernateUtil.closeSessionFactory();
	}


	}

}
