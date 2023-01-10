package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {

	
	public static void GuestswhonameendwithE(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "SELECT * FROM guests_type WHERE guest_name Like '%E'";
		
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
			
			}
					// Catch block to handle exceptions
					catch (Exception ex) {
						// Display message when exceptions occurs
						System.err.println(ex);
					}
					
	}	
	
	public static void Roomswhereguestsarepayingmorethan1000(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "SELECT guest_name FROM guests_type INNER JOIN Rooms_Typen ON guest_name hotel_id=Rooms_Typen.hotel_id  WHERE guest_payment_amount>=150;";
		
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
			
			}
					// Catch block to handle exceptions
					catch (Exception ex) {
						// Display message when exceptions occurs
						System.err.println(ex);
					}
					
	}	
	
	
public static void CountofguestsareinDELUXErooms(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "SELECT * FROM guests_type WHERE room_type_id='DELUXE'";
		
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
			
			}
					// Catch block to handle exceptions
					catch (Exception ex) {
						// Display message when exceptions occurs
						System.err.println(ex);
					}
					
	}	
	
//public static void Allroomswhicharenotactivebutroomtype(){
//	
//	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//	// Username and password to access DB
//	// Custom initialization
//	String user = "root";
//	String pass = "root";
//	Scanner scanner = new Scanner(System.in);
//	System.out.println("Enter id: ");
//	Integer idInput = scanner.nextInt();
//
//	String sql2 = "SELECT * FROM guests_type WHERE room_type_id='DELUXE'";
//	
//	   Connection con1 = null;
//		try {
//			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			// Registering drivers
//			DriverManager.registerDriver(driver);
//			// Reference to connection interface
//			con1 = DriverManager.getConnection(url, user, pass);
//			// Creating a statement
//			Statement st = con1.createStatement();
//			int rowsAffected = st.executeUpdate(sql2);
//		
//		}
//				// Catch block to handle exceptions
//				catch (Exception ex) {
//					// Display message when exceptions occurs
//					System.err.println(ex);
//				}
//				
//}	
	
	
	
	
	
	
	
	
}
