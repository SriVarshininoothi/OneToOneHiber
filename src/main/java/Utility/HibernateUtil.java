package Utility;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.OneTo.OneMapping.Address;
import com.OneTo.OneMapping.Customer;

public class HibernateUtil {

	private static final SessionFactory factory;

	static {
		Configuration confg = new Configuration();
		confg.addAnnotatedClasses(Customer.class);
		confg.addAnnotatedClass(Address.class);
		confg.configure();

		factory = confg.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
