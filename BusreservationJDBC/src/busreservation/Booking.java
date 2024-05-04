package busreservation;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Booking {
int bookingno;
int busno;
Date Tdate =new Date();
String name;
String bookingtime;
String from;
String to;
String email;
Scanner scan =new Scanner(System.in);
int num=8;  
 public boolean booking() {
	try{
		while(num==8) {
			System.out.println("Enter your name");
			  name =scan.next();
	 System.out.println("Enter the busno"); 
	  BusDao busdao =new BusDao();
	  busno =scan.nextInt();
	 if(! busdao.checkingbusno(busno)) {
		return false;
	 }
	   System.out.println("Enter the From location");
	   from =scan.next();
	   System.out.println("Enter the To location");
	   to=scan.next();
	   BookingDao bd =new BookingDao(); 
	     if( !(bd.checkingDistrict(from, to))) {
		  System.out.println("Please check the corresponding districts");
         return false;
		  }
	   System.out.println("Enter the date in the following format dd/mm/yyyy");
	   String dat =scan.next();
	   SimpleDateFormat dateformat =new SimpleDateFormat("dd/MM/yyyy");
       Tdate =dateformat.parse(dat);
	
	   System.out.println("Enter your email_id");
	   email=scan.next();	  
	   System.out.println("-----------------");
	   return true;
	   }}
	  catch (InputMismatchException | ParseException   p) {
		  System.err.println("Enter the correct values");
	  }
	return false;}
		 
int capacity=0;
   int booked=0;
	 boolean isAvailable() {
		   BusDao b  =new BusDao();
	   capacity =b.getCapacity(busno);
	  BookingDao d =new BookingDao();
	    booked =d.getBookedCount(busno,Tdate);
	  return capacity>booked;}
   }


