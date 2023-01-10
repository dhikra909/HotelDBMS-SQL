package hotel1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Throwable {

		// TODO Auto-generated method stub
		HotelDBMS hotal = new HotelDBMS();
//		hotal.addingHotelsTable();
//		
		
		Room_Type Room = new Room_Type();
//		Room.addingRoom_Type();

		Rooms Rooms = new Rooms();
//		Rooms.addingRooms_Type();
		
		
		
		Guests Guests1 = new Guests();
//		Guests1.addingGuests_Type();
		
		Employee_Type Employee= new Employee_Type();
//		Employee.addingEmployeeTable();
		
		Employees Employees = new Employees();
//		Employees.addingEmployeesTable();
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Select one of the options:");
			System.out.println("1. Insert 10,000 hotels");
			System.out.println("2. Insert 1 hote");
			System.out.println("3. Print 10 hotels");
			System.out.println("4. Make first 10 hotels 'is_Active' = false");
			System.out.println("5. Make first 10 hotels 'is_Active' = True");
			System.out.println("6. Print hotel information by user input");
			System.out.println("7.Insert 10,000 Employee");
			System.out.println("8. Print 1 Employee");
			System.out.println("9. Print 10 Employee");
			System.out.println("10. Make first 10 Employee 'is_Active' = false");
			System.out.println("11. Make first 10 Employee 'is_Active' = True");
			System.out.println("12. Print Employee information by user input");
			System.out.println("13.Insert 10,000 Room_Type");
			System.out.println("14.Insert 10,000 rooms");
			System.out.println("15.Insert 1000 Guests");
			System.out.println("16.Insert 20 Employees");

			int select = sc.nextInt();
		
			switch(select) {
			case 1:
				HotelDBMS.InsertIntoTable(100);
				break;
			case 2:
				hotal.InsertIntoTable(1);
				break;
			case 3:	
				//System.out.println("Enter How many you want to read hotels from table: ");
				//Integer numberOfHotels = sc.nextInt();
				//HotelDBMS.readFromTable(numberOfHotels);
				HotelDBMS.InsertIntoTable(10);
				break;
			case 4:	
				HotelDBMS.updateById();
				
				break;
			case 5:	
				HotelDBMS.updateToTrue();
				break;
			case 6:	
				System.out.println("Enter How many you want to read hotels from table: ");
				Integer numberOfHotels = sc.nextInt();
				HotelDBMS.readFromTable(numberOfHotels);
				break;
			case 7:	
				Employee_Type.InsertIntoTableEmployee(100);
				
				break;
			case 8:	
				Employee_Type.InsertIntoTableEmployee(1);
				
				break;

			case 9:	
				Employee_Type.InsertIntoTableEmployee(10);
				
				break;

			case 10:	
				Employee_Type.getByIdEmployee();
				
				break;
			case 11:	
				Employee_Type.updateToTrueEmployee();;
				
				break;
			case 12:	
				System.out.println("Enter How many you want to read Employee from table: ");
				Integer numberOfEmployee1 = sc.nextInt();
				Employee_Type.readFromTableEmployee(numberOfEmployee1);
				
				break;
			case 13:	
				Room_Type.InsertIntoTableRoom_Type(10);
				break;
			case 14:	
				Rooms.InsertIntoTableRooms(4);
				break;
			case 15:	
				Guests.InsertIntoTableGuests_Type(1000);
				break;
			case 16:	
				Employees.InsertIntoTableEmployees(20);
				break;

			}		
		
		
		
		
		
	}
	


}
