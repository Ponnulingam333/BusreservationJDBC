package busreservation;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException; 
public class Ticket {
  void info(int bookingno){
	 try { String query="select * from booking where bookingno="+bookingno;
	  Connection con =DBconnection.getConnection();
	  Statement st=con.createStatement();
	  ResultSet rt =st.executeQuery(query);
	  rt.next();
	  System.out.println("Bus capacity is "+rt.getInt(1));
	  System.out.println("Passanger name is "+rt.getString(2));
	 // System.out.println(rt.getDate(3));//yyyy-mm-dd format
	  java.util.Date jdate =new java.util.Date(rt.getDate(3).getTime());
	 SimpleDateFormat dateformat =new SimpleDateFormat("dd-MM-yyyy");
	  String date =dateformat.format(jdate);
	 // System.out.println("Travel date is "+ jdate); 
	  System.out.println("Travel date is "+date);
	  System.out.println("From :"+rt.getString(6)+"\nTo :"+rt.getString(7));
	  System.out.println("Booking date and time is "+ rt.getString(4));
	  System.out.println("Booking number is "+rt.getInt(5));
	  System.out.println("-----------------");
	  }
catch(SQLException |NoSuchElementException s) {
	System.err.println("Enter the correct values");
}}
  
	public static StringBuilder infoString(int bookingno){
		 try { 
			 String query="select * from booking where bookingno="+bookingno;
		 StringBuilder s =new StringBuilder();
		 Connection con =DBconnection.getConnection();
		  Statement st=con.createStatement();
		  ResultSet rt =st.executeQuery(query);
		  rt.next();
		  s.append("\nYour booking is confirmed");
		  s.append("\nThe bus capacity is :" +rt.getInt(1));
		  s.append("\nPassanger name is :"+rt.getString(2));
		 // System.out.println(rt.getDate(3));//yyyy-mm-dd format
		  java.util.Date jdate =new java.util.Date(rt.getDate(3).getTime());
		 SimpleDateFormat dateformat =new SimpleDateFormat("dd-MM-yyyy");
		  String date =dateformat.format(jdate);
		  
		 // System.out.println("Travel date is "+ jdate); 
		  s.append("\nTravel date is :"+date);
		 s.append("\nFrom :"+rt.getString(6)+"\nTo :"+rt.getString(7));
		  s.append("\nBookingtime :"+ rt.getString(4));
		 s.append("\nBooking number is :"+rt.getInt(5));
		 s.append("-----------------");
		  return s;}
		 catch(SQLException |NoSuchElementException s) {
			 System.err.println("Enter the correct values");
		 return null;
		 }
		  }}