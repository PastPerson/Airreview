package gogakproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MyDatabase {
	private String url = "jdbc:mysql://localhost:3306/airportdata?useUnicode=true&serverTimezone=UTC";
	private Connection con = null;
	
	public void connectMyDatabase() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스에 연결 중");
			con = DriverManager.getConnection(url,"root","jimin6016");
			System.out.println("데이터베이스에 연결 성공");
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ex.getMessage());
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void resetTable() {
		System.out.println("DB 초기화 시작");
		try {
			Statement state = con.createStatement();
			state.execute("DROP TABLE airportdata;");
			importdata();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void importdata() {
		System.out.println("데이터를 데이터베이스에 추가합니다.");
		try {
			Statement state = con.createStatement();
			StringBuilder sb = new StringBuilder();
//			String sql = ;
			state.execute("CREATE TABLE `airportdata`(\n"+
                    " `name_eng` VARCHAR(100),\n"+
                    " `name_kor` VARCHAR(100),\n"+
                    " `code1` VARCHAR(100),\n"+
                    " `code2` VARCHAR(100),\n"+ 
                    " `location` VARCHAR(100),\n"+
                    " `country_eng` VARCHAR(100),\n"+
                    " `country_kor` VARCHAR(100),\n"+
                    " `city_eng` VARCHAR(100),\n"+
                    " PRIMARY KEY (`code1`));");
			File file = new File("C:\\Users\\jikun\\IdeaProjects\\Airreview\\gogakproject\\국토교통부_세계공항_정보_20211231.csv");
			
			List<String[]> result = new ArrayList<String[]>();
			try {
				FileReader fr = new FileReader(file);
				BufferedReader in = new BufferedReader(fr);
				Charset.forName("UTF-8");
				String line;
				while((line = in.readLine()) != null) {
					String[] arr = line.split(",");
					if(arr.length == 8) {
						result.add(arr);
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			for(String[] item : result) {
				String query = "insert into airportdata"
						+ "(name_eng,name_kor,code1,code2,location,country_eng,country_kor,city_eng)"
						+ " values ('"
						+ item[0] + "','"
						+ item[1] + "','"
						+ item[2] + "','"
						+ item[3] + "','"
						+ item[4] + "','"
						+ item[5] + "','"
						+ item[6] + "','"
						+ item[7] + "');";
				//System.out.println(item[1]);
				state.execute(query);
			}
		}catch(SQLException e) {
			System.out.println("작업 중 오류 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("작업 완료");
	}
	public ArrayList getLocData(){
		try {
			PreparedStatement ps = con.prepareStatement("SELECT location FROM airportdata");
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String> ();
			
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
			
			HashSet<String> arr2 = new HashSet<String>(arr);
			ArrayList<String> arr3 = new ArrayList<String>(arr2);
			
			System.out.println(arr3);
			return arr3;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList getCountryData(String loc){
		try {
			String sql = "SELECT country_kor FROM airportdata WHERE location LIKE " + "'" +loc+"'";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String> arr = new ArrayList<String> ();
			
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
			HashSet<String> arr2 = new HashSet<String>(arr);
			ArrayList<String> arr3 = new ArrayList<String>(arr2);
			
			
			return arr3;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public MyDatabase() {
		connectMyDatabase();
		resetTable();
		getLocData();
	}
}