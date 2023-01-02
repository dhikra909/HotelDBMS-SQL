package hotel1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelDBMS hotal = new HotelDBMS();
		hotal.addingHotelsTable();
		
		
		Room_Type Room = new Room_Type();
		Room.addingRoom_Type();

		Rooms Rooms = new Rooms();
		Rooms.addingRooms_Type();

		
		Guests Guests1 = new Guests();
		Guests1.addingGuests_Type();
		
		Employee_Type Employee= new Employee_Type();
		Employee.addingEmployeeTable();
		
		Employees Employees = new Employees();
		Employees.addingEmployeesTable();
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Select one of the options:");
			System.out.println("1. Insert 10,000 hotels");
			System.out.println("2. Insert 1 hote");
			System.out.println("3. Print 10 hotels");
			System.out.println("4. Make first 10 hotels 'is_Active' = false");
			System.out.println("5. Print hotel information by user input");
			int select = sc.nextInt();
		
			switch(select) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:	
		
				break;
			case 4:	
				
				break;
			case 5:	
				
				break;
			
			}		
		
		
		
		
		
	}
	


}
