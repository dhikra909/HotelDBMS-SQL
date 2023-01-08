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

public class Employee_Type {

	public static boolean addingEmployeeTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Employee " 
		+ "(id INTEGER , " 
				+ " employee_type_name VARCHAR(20) not NULL, "
				+ " created_date date , " 
				+ " updated_date date not NULL, "
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


public static void InsertIntoTableEmployee(int insert) throws Throwable {

	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	String user = "root";
	String pass = "root";
    Scanner sa=new Scanner(System.in);
	String employee_type_name = "Oman";
	String created_date = "2022-12-15";
	String updated_date = "2023-11-11";
	boolean is_Active = true;
	Random rn = new Random();
	Integer numberToAdd = rn.nextInt(100);
	for (int i = 0; i <= insert; i++) {
		String sql = "insert into Employee values (" + i + numberToAdd + ", '" + employee_type_name + i + "', '"
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


public static void readFromTableEmployee(int  numberOfEmployee1) {
	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	// Username and password to access DB
	// Custom initialization
	String user = "root";
	String pass = "root";
	Scanner scanner = new Scanner(System.in);

	String sql2 = "SELECT * FROM Employee";
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
		while (resultSet.next()&& count<numberOfEmployee1) {
			Integer id = resultSet.getInt("id");
			String employee_type_name = resultSet.getString("employee_type_name");

			Date created_date = resultSet.getDate("created_date");
			Date updated_date = resultSet.getDate("updated_date");
			Integer is_Active = resultSet.getInt("is_Active");
			System.out.println(id + ", " + employee_type_name + ", "  + created_date + " ,"
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


public static void getByIdEmployee(){
	
	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	// Username and password to access DB
	// Custom initialization
	String user = "root";
	String pass = "root";
	Scanner scanner = new Scanner(System.in);
    System.out.println("Enter id");
    Integer inputid = scanner.nextInt();

     String sql2= "Select * from Employee where id=" + inputid;	
    		
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
			String employee_type_name= resultSet.getString("employee_type_name");
			Date created_date = resultSet.getDate("created_date");
			Date updated_date = resultSet.getDate("created_date");
			Integer is_Active = resultSet.getInt("is_Active");
			System.out.println(id + ", " + employee_type_name + ", " + created_date + " ,"
					+ updated_date + ", " + is_Active);
		}
	}
		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
		
	}

public static void updateToTrueEmployee(){
	
	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	// Username and password to access DB
	// Custom initialization
	String user = "root";
	String pass = "root";
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter id: ");
	Integer idInput = scanner.nextInt();
//	System.out.println("Enter Hotel Name: ");
//	String NameInput = scanner.next();
//	System.out.println("Enter Hotel Location: ");
//	String LocatoinInput = scanner.next();
	String sql2 = "UPDATE Employee SET is_Active= True where id<="+idInput;
	
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

  public static void deleteByIdEmployee(){
	
	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	// Username and password to access DB
	// Custom initialization
	String user = "root";
	String pass = "root";
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter id: ");
	Integer idInput = scanner.nextInt();
	
	String sql2 = "delete from Employee where id ='" + idInput +"'";
		
	
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
				String Employee_name = resultSet.getString("Employee_name");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Integer is_Active = resultSet.getInt("is_Active");
				System.out.println(id + ", " + Employee_name + ", "+ created_date + " ,"
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

