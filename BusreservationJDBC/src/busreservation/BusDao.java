package busreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class BusDao {
	int capacity;
	Date date;
	 Scanner scan =new Scanner(System.in);
	 
	 void displayInfo(){
		   try{Connection con =DBconnection.getConnection();
		   String query ="Select * from Bus";
		   Statement st =con.createStatement();
		   ResultSet rt =st.executeQuery(query);
		   while(rt.next()) {
			   System.out.println("Bus number is "+rt.getInt(1));
			   System.out.println("Bus capacity is "+rt.getInt(2));
			   System.out.println("Bus contains ac is  "+rt.getBoolean(3));
			   System.out.println("-----------------");
		   }
		   con.close();}
		   catch(SQLException s) {
			   System.err.println("Error occured");
		   }
		   
		   
	   }
	 public int getCapacity(int busno) {
		 try { Connection con =DBconnection.getConnection();
		   String query ="Select capacity from bus where busno=?";
		  PreparedStatement pst =con.prepareStatement(query);
		  pst.setInt(1, busno);
		   ResultSet rt =pst.executeQuery();
		   rt.next();
			return rt.getInt(1);}
		
		 catch(SQLException s) {
			 System.err.println("Error occured");
			 return 0 ;
		 }
		}
	 
	public  boolean checkingbusno(int busno) {
		try { String query ="select exists(select * from bus where busno="+busno+")";
		 Connection con =DBconnection.getConnection();
		 Statement st =con.createStatement();
		 ResultSet rt =st.executeQuery(query);
		 rt.next();
		 return rt.getBoolean(1);}
		catch(SQLException s) {
			System.err.println("Enter the correct booking number");
			return false;
		}
		}
	 
	public  void availableSeats(){
		  try { System.out.println("Enter the busno");
		   int Busno=scan.nextInt();
		   if(checkingbusno(Busno)) {
		   int capacity = getCapacity(Busno);
		    System.out.println("Enter the date in the following format dd/MM/yyyy");
			   String dat =scan.next();
			   SimpleDateFormat dateformat =new SimpleDateFormat("dd/MM/yyyy");
			   try{
				    date =dateformat.parse(dat);
			   }
			   catch(ParseException p) {
				 System.out.println("Please enter the given data format only");
			   }
		   String query2 ="Select count(bname) from booking where busno=? and Traveldate=?";
		   Connection con =DBconnection.getConnection();
		   PreparedStatement pst =con.prepareStatement(query2);
	   pst.setInt(1,Busno);
	   java.sql.Date sdate = new java.sql.Date(date.getTime());
	   pst.setDate(2,sdate);
	  
	   ResultSet rt1 =pst.executeQuery();
	   rt1.next();
	   int booked =rt1.getInt(1);
	   
	   int seats=capacity-booked;
	   if(seats==0) {
	   System.out.println("There is no available seats");
	   }
	   else {
		   System.out.println("Available seats is "+seats);
	   }}
	   else {
		   System.out.println("Enter the correct bus number");
	   }}
		  
		  catch(SQLException s) {
			  System.err.println("Enter the correct values ");
			  }}
	   }
