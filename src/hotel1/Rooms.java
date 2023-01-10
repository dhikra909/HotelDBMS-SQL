package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Rooms {

	public static boolean addingRooms_Type() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Rooms "
		+"(id INTEGER , " 
		+ " room_type_id  INTEGER  REFERENCES Rooms_Type_id(id), "
		+ " hotel_id INTEGER  REFERENCES Hotels(id)," 
		+ " created_date date not null ," 
		+ " updated_date date,  "
		+ " is_Active BIT not NULL, "
		+ " PRIMARY KEY ( id ))";
		

		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = (Statement) conn.createStatement();
		
			try{	
				st.executeUpdate(sqlDB);
				   System.out.println("Table Created Successfully");   	 
			      } catch (SQLException e) {
			         e.printStackTrace();
			      }		
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}
	
	public static void InsertIntoTableRooms(int insert) throws Throwable {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
	    Scanner sa=new Scanner(System.in);
		
		String created_date = "2022-12-15";
		String updated_date = "2023-11-11";
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		String room_type_id = "STANDARD" +numberToAdd ;
		int hotalID = 90;
		int roomID = 2;
		
		
		for (int i = 1; i <= 2; i++) {
		
			String sql = "insert into Rooms values (" + i + ", " + roomID  + ", "+hotalID+ ", '"
					 + created_date + "', '" + updated_date + "', " + is_Active + ")";
System.out.println(sql);
			Connection con = null;
			
			try {
				//load the JDBC Driver
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				//get connected to the db according the parameters
				con = DriverManager.getConnection(url, user, pass);
				Statement st = (Statement) con.createStatement();
				int m = st.executeUpdate(sql);
				if (m >= 0)
					System.out.println("insert data successfully");
				else
					System.out.println("faild inserted ");
				con.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}
		}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
