package gogakproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDatabase {
	private String url = "jdbc:mysql://localhost/airdatabase?characterEncoding=UTF-8&serverTimezone=UTC";
	private String sql = "SELECT * FROM airportdata";
	private Connection con = null;
	
	public void connectMyDatabase() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스에 연결 중");
			con = DriverManager.getConnection(url,"root","junni1561");
			System.out.println("데이터베이스에 연결 성공");
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ex.getMessage());
		}
	}
	public void printData() throws SQLException{
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + "\t");
			
		}
	}
	public MyDatabase() {
		connectMyDatabase();
		try {
			printData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
