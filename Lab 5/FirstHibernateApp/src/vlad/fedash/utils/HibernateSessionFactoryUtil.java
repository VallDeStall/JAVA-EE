package vlad.fedash.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import vlad.fedash.entity.BookDatas;
import vlad.fedash.entity.Reader;

public class HibernateSessionFactoryUtil {
	private static SessionFactory sessionFactory;

	private HibernateSessionFactoryUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(Reader.class);
				configuration.addAnnotatedClass(BookDatas.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
				sessionFactory = configuration.buildSessionFactory(builder.build());

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return sessionFactory;
	}
}