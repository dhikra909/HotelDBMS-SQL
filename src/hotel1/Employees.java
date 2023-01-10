package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Employees {

	public static boolean addingEmployeesTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Employees " 
		+ "(id INTEGER , " 
				+ " employees_type_id INTEGER  REFERENCES  Employee_Type(id), "
				+ " room_id  INTEGER  REFERENCES  Rooms(id), "
				+" created_date date not NULL,"
				+" updated_date date ,"
				+" is_Active BIT not NULL, "
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
	
	
	public static void InsertIntoTableEmployees(int insert) throws Throwable {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
	    Scanner sa=new Scanner(System.in);
		
		String created_date = "2022-12-15";
		String updated_date = "2023-11-11";
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		String employees_type_name = "Oman" +numberToAdd ;
		int empId = 90;
		int roomID = 2;
		
		
		for (int i = 0; i <= 20; i++) {
		
			String sql = "insert into Employees values (" + i + ", " + empId  + ", "+roomID + ", '"
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
