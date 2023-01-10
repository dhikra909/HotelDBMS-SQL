package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Guests {

	public static boolean addingGuests_Type() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Guests "
		        + "(id INTEGER , " 
				+ " guest_name  VARCHAR(20) not NULL, "
				+ " guest_phone VARCHAR (20) not NULL, " 
				+ " guest_accompanying_members INTEGER not NULL , "
				+ " guest_payment_amount INTEGER not NULL ,"
				+ " room_id INTEGER  REFERENCES Rooms(id), "
				+ " hotel_id INTEGER  REFERENCES Hotels(id), "
				+ " created_date Date not NULL, "
				+ " updated_date Date , "
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
	
	public static void InsertIntoTableGuests_Type(int insert) throws Throwable {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
	    Scanner sa=new Scanner(System.in);
	    String guest_phone="77";
	    Integer guest_accompanying_members=6;
	    Integer guest_payment_amount=3;
		String created_date = "2022-12-15";
		String updated_date = "2023-11-11";
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		String guest_name = "Oman" +numberToAdd ;
		int hotelId = 90;
		int roomID = 2;
		
		
		for (int i = 1; i <= 1000; i++) {
		
			String sql = "insert into Guests values (" + i + ", " +guest_name + ", "+guest_phone+ ", "+guest_accompanying_members+ ", "+guest_payment_amount+ ", "+ hotelId  + ", "+roomID+ ", '"
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
