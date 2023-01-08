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
		+ " room_type_id  INTEGER  REFERENCES Room_Type(id), "
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
	
	public static void InsertIntoTablerooms(int insert) throws Throwable {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
        Scanner sa=new Scanner(System.in);
		String room_type_id = "d";
		String created_date = "2021-08-17";
		String updated_date = "2022-12-14";
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		for (int i = 0; i <= insert; i++) {
			String sql = "insert into rooms values (" + i + numberToAdd + ", '" + room_type_id + i + "', '"
					+ created_date + "', '" + updated_date + "', " + is_Active + ")";
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
