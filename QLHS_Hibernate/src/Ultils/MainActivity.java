package Ultils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.*;

import com.sun.jmx.snmp.Timestamp;

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		

//		showList();

//		SaveSinhVien(generatingObject());
		showList();
	}

	public static SinhVien generatingObject() {
		// gen msv random
		String timecurent = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		// gen edge random
		Random rand = new Random();
		// Obtain a number between [0 - 49].
		int edge = rand.nextInt(50);

		SinhVien sv = new SinhVien("DTC" + timecurent, "Hiep " + edge, edge, "TN", "Nam");
		return sv;
	}

	public static void showList() {
		List<SinhVien> list = listSinhVien();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("msv : " + list.get(i).getMsv());
			System.out.println("ten : " + list.get(i).getTen());
			System.out.println("tuoi : " + list.get(i).getTuoi());
			System.out.println("qq : " + list.get(i).getQq());
			System.out.println("gt : " + list.get(i).getGt());
			System.out.println("-------------");
		}
	}

	public static void SaveSinhVien(SinhVien sv) {
		Transaction transaction = null;
		try {
			Session session = HibernativeUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(sv);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static List listSinhVien() {
		try {
			Session session = HibernativeUtils.getSessionFactory().openSession();
			return session.createQuery("from SinhVien").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
