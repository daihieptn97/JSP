package Ultils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernaterUltils {
	public static SessionFactory sessionFactory;

	public HibernaterUltils() {
		// TODO Auto-generated constructor stub
	}

	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			
			try {
				Configuration configuration = new Configuration();

				Properties pr = new Properties();

				pr.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				pr.put(Environment.URL, "jdbc:mysql://localhost:3306/bookmanager");
				pr.put(Environment.USER, "root");
				pr.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				
				pr.put(Environment.SHOW_SQL, "true");

				configuration.setProperties(pr);
				configuration.addAnnotatedClass(Sach.class);
				configuration.addAnnotatedClass(Mua.class);
				configuration.addAnnotatedClass(NguoiMua.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				System.out.println("e : ");
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return sessionFactory;
	}
}
