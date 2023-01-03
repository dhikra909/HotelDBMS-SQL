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

	public static void InsertIntoTable(int numOfRows) {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";

		String sql = "INSERT INTO Hotels (id, hotel_name, hotel_location,created_date,updated_date,is_Active) VALUES (?, ?, ?,?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;

//		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			pstmt = con.prepareStatement(sql);
			for (int i = 1; i < numOfRows; i++) {
				Random rn = new Random();
				Integer numberToAdd = rn.nextInt(100);
				String stringToAdd = "dhikra" + numberToAdd;
				boolean boolToAdd = true;
				String created_date = "2000-10-10";
				String Updated_date = "2001-11-11";
				// int id = 0;

				pstmt.setInt(1, numOfRows);
				pstmt.setString(2, stringToAdd);
				pstmt.setString(3, stringToAdd);
				pstmt.setString(4, created_date);
				pstmt.setString(5, Updated_date);
				pstmt.setBoolean(6, boolToAdd);
				pstmt.executeUpdate();
			}

			System.out.println(numOfRows + " rows inserted successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void InsertIntoTable1() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		System.out.println("enter id");
		Integer id = scanner.nextInt();

		System.out.println("enter name");
		String name = scanner.next();

		System.out.println("enter location");
		String location = scanner.next();

		System.out.println("enter created date");
		String created_date = scanner.next();

		System.out.println("updated_date");
		String updated_date = scanner.next();

		System.out.println("is_Active");
		Boolean is_Active = scanner.nextBoolean();

		String sql = "insert into Hotels values(" + id + ",'" + name + "','" + location + "','" + created_date + "','"
				+ updated_date + "'," + is_Active + ")";
		Connection con = null;

//			Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			Statement st = (Statement) con.createStatement();

			try {
				st.executeUpdate(sql);
				System.out.println("Inserted Successfully");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			
		}
	}
}
