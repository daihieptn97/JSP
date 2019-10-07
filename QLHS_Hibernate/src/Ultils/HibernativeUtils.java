package Ultils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernativeUtils {
	public static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			try {
				Configuration configuration = new Configuration();

				// seting
				Properties pr = new Properties();

				pr.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				pr.put(Environment.URL, "jdbc:mysql://localhost:3306/qlsv");
				pr.put(Environment.USER, "root");
				pr.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				pr.put(Environment.SHOW_SQL, "true");

				configuration.setProperties(pr);

				configuration.addAnnotatedClass(SinhVien.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);		
			} catch (Exception e) {
				e.printStackTrace();
				return null;
				// TODO: handle exception
			}
		}

		return sessionFactory;

	}
}
