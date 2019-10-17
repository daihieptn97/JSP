package Ultils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		insert(new Sach("Sach toan 232", 20000));
//		delete(4);
		
		List<Sach> list = show();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getTen());
			System.out.println(list.get(i).getGia());
			System.out.println("=============");
		}
	}
	
	public static List<Sach> show() {
		try {
			Session session = HibernaterUltils.getSessionFactory().openSession();
			System.out.println(session);
			return session.createQuery("from Sach").list();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	public static void delete(int id) {
		Session session = HibernaterUltils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Sach sach = new Sach();
		sach.setId(id);
		session.delete(sach);
		transaction.commit();
		
	}
	
	public static void insert(Sach sach) {
		try {
			Session  session = HibernaterUltils.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(sach);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
