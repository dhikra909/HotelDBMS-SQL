package hotel1;

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
		
	}

}
