package busreservation;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Busreservation {
public static void main(String []args)  {
		Scanner scan =new Scanner(System.in);
		int useropt=10;
   
		while(useropt==10) {
			try {
		  System.out.println("-----------------");
		System.out.println("Enter 1 to businfo \nEnter 2 to booking \nEnter 3 to other\nEnter 4 to exit");
		  System.out.println("-----------------");
		useropt=scan.nextInt();
		
		if(useropt==1) {
		BusDao bus =new BusDao();
		bus.displayInfo();
	}
		else if(useropt==2) {
		Booking booking =new Booking();
		if(booking.booking()) {
			if(booking.isAvailable()) {
				BookingDao b =new BookingDao();	
						b.addBooking(booking);
						}
			else{
				System.out.println("Sorry for the inconvenience we don't have the buses right now");
			}}
		}
		else if(useropt==3) {
			Others other =new Others();
			other.showOptions();
		}
		else if(useropt==4) {
			System.out.println("Thank you for the visit");
			  System.out.println("-----------------");
			  break;
			}
		else {
			System.out.println("Enter only corresponding above values");
		}
		  System.out.println("-----------------");
		System.out.println("Enter 5 to previous menu");
		  System.out.println("-----------------");
		useropt=scan.nextInt();
		while(true) {
			if(useropt==5) {
			useropt=10;
			break;}
		else {
			 System.out.println("-----------------");
			System.out.println("Enter 5 to previous menu");
			 System.out.println("-----------------");
		useropt=scan.nextInt();
			if(useropt==5) {
				useropt =10;
			break;}
		}}}
			catch(InputMismatchException s) {
				 System.out.println("-----------------");
				 System.out.println("Enter the correct value 5 to continue");
				 scan.nextLine();
				 scan.nextInt();
				}
				
					
		}
		scan.close();
}


	
	}
