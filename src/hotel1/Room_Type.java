package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Room_Type {

	
	public static boolean addingRoom_Type() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Room " + "(id INTEGER , " + " room_type_name  VARCHAR(20) not NULL, "
				+ " created_date date, " + " updated_date date , "+" is_Active Boolean not NULL, " + " PRIMARY KEY ( id ))";
		
//		String in = "INSERT INTO Room VALUES(1,gg,'1921-3-12','1233-5-14'" 
		
		
		
		
		
		
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
}
