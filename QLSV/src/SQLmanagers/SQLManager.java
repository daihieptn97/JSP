package SQLmanagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ultils.Sinhvien;

public class SQLManager {
	private String url = "jdbc:mysql://localhost:3306/qlhs";
	private String user = "root";
	private String pass = "";
	private Connection conn = null;

	public void openConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, pass);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void closeConnec() throws SQLException {
		if (conn != null || !conn.isClosed()) {
			conn.close();
		}
	}

	public List<Sinhvien> getAllData() {
		List<Sinhvien> list = new ArrayList<Sinhvien>();
		openConnection();

		String sql = "SELECT * FROM `sv`";
		System.out.println(conn);
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				list.add(new Sinhvien(resultSet.getInt(1), resultSet.getInt(4), resultSet.getString(3),
						resultSet.getString(2)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean delete(int id) throws SQLException {
		String sql = "DELETE FROM `sv` WHERE id = ?";
		openConnection();
		PreparedStatement pr = conn.prepareStatement(sql);
		pr.setInt(1, id);
		int deleteok = pr.executeUpdate();
//		System.out.println(deleteok);
//		System.out.println(pr.getUpdateCount());
		pr.close();
		return deleteok != 0;
	}

	public boolean insert(Sinhvien sinhvien) {
		String sql = "INSERT INTO `sv`(`msv`, `ten`, `tuoi`) VALUES (?, ? , ?)";
		boolean res = false;
		openConnection();
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			preparedStatement.setString(1, sinhvien.getMsv());
			preparedStatement.setString(2, sinhvien.getTen());
			preparedStatement.setInt(3, sinhvien.getTuoi());

			res = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	public Sinhvien getSinhVienByID(int ID) {

		String sql = "SELECT * FROM `sv` WHERE id = ?";
		this.openConnection();
		try {
			Sinhvien sinhvien = null;
			PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				sinhvien = new Sinhvien(rs.getInt(1), rs.getInt(4), rs.getString(3), rs.getString(2));
			}
			return sinhvien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public boolean update(Sinhvien sv) {
		String sql = "UPDATE `sv` SET `msv`=?,`ten`=?,`tuoi`=? where id = ?";
		openConnection();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, sv.getMsv());
			preparedStatement.setString(2, sv.getTen());
			preparedStatement.setInt(3, sv.getTuoi());
			preparedStatement.setInt(4, sv.getId());
			
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
