package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Room_Type {

	
	public static boolean addingRoom_Type() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Room " + "(id INTEGER , " + " room_type_name  VARCHAR(20) not NULL, "
				+ " created_date date, " + " updated_date date , "+" is_Active Boolean not NULL, " + " PRIMARY KEY ( id ))";
		

		
		
		
		
		
		
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
	
	public static void InsertIntoTableroom(int insert) throws Throwable {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
        Scanner sa=new Scanner(System.in);
		String room_name = "d";
		String created_date = "2021-08-17";
		String updated_date = "2022-12-14";
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		for (int i = 0; i <= insert; i++) {
			String sql = "insert into Hotels values (" + i + numberToAdd + ", '" + room_name + i + "', '"
					 + i + "', '" + created_date + "', '" + updated_date + "', " + is_Active + ")";
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
