package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;

import Ultils.Sach;

public class SQLmanager {

	public SQLmanager() {
		// TODO Auto-generated constructor stub
	}

	private String url = "jdbc:mysql://localhost:3306/bookmanager";
	private String pass = "";
	private String user = "root";
	private Connection conn = null;

	public void getOpenConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Ultils.Sach> listAll() {
		getOpenConnection();
		List<Sach> ls = new ArrayList<Sach>();
		try {
			String sql = "SELECT * FROM `sach`";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				// System.out.println(resultSet.getString(2));
				ls.add(new Sach(resultSet.getInt(1), resultSet.getInt(3), resultSet.getString(2)));
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public boolean insert(Sach sach) {
		boolean c = false;
		getOpenConnection();
		try {
			String sql = "INSERT INTO `sach`( `tensach`, `giasach`) VALUES (?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, sach.getTen());
			preparedStatement.setInt(2, sach.getGia());
			int r = preparedStatement.executeUpdate();
			System.out.println(r);
			c = r > 0;
		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}

		return c;
	}

	public boolean update(Sach sach) {
		boolean c = false;
		try {
			String sql = "UPDATE `sach` SET `tensach`=?,`giasach`=? WHERE id  = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, sach.getTen());
			preparedStatement.setInt(2, sach.getGia());
			preparedStatement.setInt(3, sach.getId());

			c = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return c;
	}
}
