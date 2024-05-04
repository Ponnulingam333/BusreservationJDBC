package busreservation;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Others {
	int bookingno;
	int num;
	int numb=1;
	Scanner scan=new Scanner(System.in);
      public void showOptions(){
    	try {  
    		  System.out.println("-----------------");
    	  System.out.println("Enter 1 to cancelation");
    	  System.out.println("Enter 2 to availableSeats");
    	  System.out.println("Enter 3 to ticketdetails");
    	  System.out.println("Enter 8 to exit");
    	  System.out.println("-----------------");
    		while(numb==1) {
			 num =scan.nextInt();
			   if(num==1) {
				   BookingDao dao =new BookingDao();
				   dao.cancelation();
			   }
			   if(num==2) {
				   BusDao da =new BusDao(); 
				   da.availableSeats();
			   }
			   if(num==3) {
				   Ticket t =new Ticket();
				   System.out.println("Enter your booking number");
				   bookingno=scan.nextInt();
				  t.info(bookingno);
				  }
			   break;
			   }}
    	  catch(NoSuchElementException s) {
       System.err.println("Something is wrong Enter the correct values");}
    	}
      }

