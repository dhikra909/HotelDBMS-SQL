package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Employees {

	public static boolean addingEmployeesTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Employees " 
		+ "(id INTEGER , " 
				+ " employee_type_id INTEGER  REFERENCES  Employee_Type(id), "
				+ " room_id  INTEGER  REFERENCES  Hotels(id), "
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
	
public static void updateById(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();
//		System.out.println("Enter Hotel Name: ");
//		String NameInput = scanner.next();
//		System.out.println("Enter Hotel Location: ");
//		String LocatoinInput = scanner.next();
		String sql2 = "UPDATE Hotels SET is_Active= false where id<="+idInput;
		
		   Connection con1 = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);
				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);
				// Creating a statement
				Statement st = con1.createStatement();
				int rowsAffected = st.executeUpdate(sql2);
				// System.out.println(resultSet);
				/*
				 * while (resultSet.next()) { Integer id = resultSet.getInt("id"); String
				 * hotel_name = resultSet.getString("hotel_name"); String hotel_location =
				 * resultSet.getString("hotel_location"); Date created_date =
				 * resultSet.getDate("created_date"); Date updated_date =
				 * resultSet.getDate("created_date"); Integer is_Active =
				 * resultSet.getInt("is_Active"); System.out.println(id + ", " + hotel_name +
				 * ", " + hotel_location + ", " + created_date + " ," + updated_date + ", " +
				 * is_Active); }
				 */
			}
					// Catch block to handle exceptions
					catch (Exception ex) {
						// Display message when exceptions occurs
						System.err.println(ex);
					}
					
	}
	
	
public static void updateToTrue(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();
//		System.out.println("Enter Hotel Name: ");
//		String NameInput = scanner.next();
//		System.out.println("Enter Hotel Location: ");
//		String LocatoinInput = scanner.next();
		String sql2 = "UPDATE Hotels SET is_Active= True where id<="+idInput;
		
		   Connection con1 = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);
				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);
				// Creating a statement
				Statement st = con1.createStatement();
				int rowsAffected = st.executeUpdate(sql2);
				// System.out.println(resultSet);
				/*
				 * while (resultSet.next()) { Integer id = resultSet.getInt("id"); String
				 * hotel_name = resultSet.getString("hotel_name"); String hotel_location =
				 * resultSet.getString("hotel_location"); Date created_date =
				 * resultSet.getDate("created_date"); Date updated_date =
				 * resultSet.getDate("created_date"); Integer is_Active =
				 * resultSet.getInt("is_Active"); System.out.println(id + ", " + hotel_name +
				 * ", " + hotel_location + ", " + created_date + " ," + updated_date + ", " +
				 * is_Active); }
				 */
			}
					// Catch block to handle exceptions
					catch (Exception ex) {
						// Display message when exceptions occurs
						System.err.println(ex);
					}
					
	}
	
      public static void deleteById(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();
		
		String sql2 = "delete from hotels where id ='" + idInput +"'";
			
		
		   Connection con1 = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);
				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);
				// Creating a statement
				Statement st = con1.createStatement();
				ResultSet resultSet = st.executeQuery(sql2);
				// System.out.println(resultSet);
				while (resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String hotel_name = resultSet.getString("hotel_name");
					String hotel_location = resultSet.getString("hotel_location");
					Date created_date = resultSet.getDate("created_date");
					Date updated_date = resultSet.getDate("created_date");
					Integer is_Active = resultSet.getInt("is_Active");
					System.out.println(id + ", " + hotel_name + ", " + hotel_location + ", " + created_date + " ,"
							+ updated_date + ", " + is_Active);
				}
			}
					// Catch block to handle exceptions
					catch (Exception ex) {
						// Display message when exceptions occurs
						System.err.println(ex);
					}
					
	}
	
	
	
}
