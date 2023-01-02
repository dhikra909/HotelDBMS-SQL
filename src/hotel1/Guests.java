package hotel1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
