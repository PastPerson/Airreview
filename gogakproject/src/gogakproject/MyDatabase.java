package gogakproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase {
	public void connectMyDatabase() {
		String url = "jdbc:mysql://localhost/airdatabase?characterEncoding=UTF-8&serverTimezone=UTC";
		
		Connection con = null;
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
	public MyDatabase() {
		connectMyDatabase();
	}
}
