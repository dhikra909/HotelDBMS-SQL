package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HotelDBMS {
	public static boolean addingHotelsTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER , " + " hotel_name VARCHAR(20) not NULL, "
				+ " hotel_location VARCHAR(20), " + " created_date date not NULL, " + " updated_date date,"
				+ " is_Active BIT not NULL, " + " PRIMARY KEY ( id ))";

//		String in = "INSERT INTO Hotels VALUES(1,'KHU','JAH','1996-11-18','1997-06-17',true),"
//				 + "(2,'KHA','JAH','1998-07-27','1997-01-11',true),"
//				 +  "(3,'ARE','YAH','2000-12-07','1997-02-12',true),"
//				 + "(4,'AHM','YAH','1996-05-25','1997-03-13',true),"
//				 + "(5,'AMM','JAB','2001-06-15','1997-04-14',true),"
//				 + "(6,'RIT','JAB','2005-05-05','1997-05-15',true),"
//				 + "(7,'JAB','JAB','1997-08-02','1997-06-16',true),"
//				 + "(8,'SAL','HAM','1996-05-25','1997-07-18',true),"
//				 + "(9,'SAHE','HAM','1996-05-25','1997-08-19',true),"
//				 + "(10,'FAH','HAM','1998-05-05','1997-09-20',true)," 
//				 + "(11,'HAM','BAR','2007-09-10','1997-10-22',true),"
//				 + "(12,'HAM','BAR','2005-08-14','1997-11-23',true)";

		Connection conn = null;
		try {
			//load the JDBC Driver
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = (Statement) conn.createStatement();

//			int m = st.executeUpdate(sqlDB);
//			int s= st.executeUpdate(in);
//			if ((m >= 0)&& (s >= 1)){
//				System.out.println("Created table in given database...");
//				System.out.println("Inserted to table SUCC...");
//				return true;
//			} else {
//				System.out.println(" table already Created in given database...");
//				System.out.println(" INSERTED DATA TO TABLE...");
//			}
			try {
				st.executeUpdate(sqlDB);
				System.out.println("Table Created Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}

	public static void InsertIntoTable(int insert) throws Throwable {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
        Scanner sa=new Scanner(System.in);
		String hotel_name = "Oman";
		String hotel_location = "Muscat";
		String created_date = "2022-12-15";
		String updated_date = "2023-11-11";
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		for (int i = 0; i <= insert; i++) {
			String sql = "insert into Hotels values (" + i + numberToAdd + ", '" + hotel_name + i + "', '"
					+ hotel_location + i + "', '" + created_date + "', '" + updated_date + "', " + is_Active + ")";
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
	
	
	public static void readFromTable(int  numberOfHotels) {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);

		String sql2 = "SELECT * FROM hotels";
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
			int count=0;
			while (resultSet.next()&& count<numberOfHotels) {
				Integer id = resultSet.getInt("id");
				String hotel_name = resultSet.getString("hotel_name");
				String hotel_location = resultSet.getString("hotel_location");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Integer is_Active = resultSet.getInt("is_Active");
				System.out.println(id + ", " + hotel_name + ", " + hotel_location + ", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
				count++;
			}
		}
		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	}
	
	public static void getById(){
	
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter id");
	    Integer inputid = scanner.nextInt();

	     String sql2= "Select * from Hotels where id=" + inputid;	
	    		
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
