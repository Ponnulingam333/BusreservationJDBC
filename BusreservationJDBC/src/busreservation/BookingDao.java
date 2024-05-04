package busreservation;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.*;
public class BookingDao {
	Scanner scan =new Scanner(System.in);
    public int getBookedCount(int busno,java.util.Date date) {
    	try{
    		Connection con =DBconnection.getConnection();
    	String query ="select count(bname) from booking where busno =? and Traveldate =?";
    	PreparedStatement pst =con.prepareStatement(query);
       pst.setInt(1,busno);
       java.sql.Date sdate =new java.sql.Date(date.getTime());
       pst.setDate(2,sdate);
    	ResultSet rt =pst.executeQuery();
    	rt.next();
    	return rt.getInt(1);}
    	catch(SQLException s) {
    		return 0;
    	}}
    public void addBooking(Booking booking) {
    	try{
    		Random random =new Random();
    	   booking.bookingno=random.nextInt(50000);
    	/* LocalDate ldt =LocalDate.now(); 
    	 DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	 For date only*/
    	 LocalDateTime ldt =LocalDateTime.now(); 
    	// System.out.println(ldt);
    	 DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    	 booking.bookingtime =ldt.format(formatter);
    	 //LocatDateTime format to customized format
    	Connection con =DBconnection.getConnection();
    	String query ="Insert into booking values(?,?,?,?,?,?,?,?)";
    	PreparedStatement pst = con.prepareStatement(query);
    	pst.setInt(1,booking.busno);
    	pst.setString(2,booking.name);
    	java.sql.Date date =new java.sql.Date(booking.Tdate.getTime());
    	pst.setDate(3,date);
    	pst.setString(4,booking.bookingtime);
    	pst.setInt(5, booking.bookingno);
    	pst.setString(6,booking.from);
    	pst.setString(7,booking.to);
    	pst.setString(8,booking.email);
    	pst.executeUpdate();
    	System.out.println("Your booking is confirmed");
    	System.out.println("Your booking number is "+booking.bookingno);
    	System.out.println("Your booking date and time is "+booking.bookingtime);
        SimpleDateFormat simple =new SimpleDateFormat("dd/MM/yyyy");
        String sdate =simple.format(booking.Tdate);
    	System.out.println("Your booking date is "+sdate);
    	Sendemail.sendingMail(booking.email,Ticket.infoString(booking.bookingno));
    	  System.out.println("-----------------");
    }
    catch(SQLException s) {
    	System.err.println("Error occured");
    }}
    
    public boolean checkingbookingno(int bookingno) {
    	try{
    	String query ="select exists(select busno from booking where bookingno="+bookingno+")";
    	Connection con =DBconnection.getConnection();
    	Statement st =con.createStatement();
    	ResultSet rt =st.executeQuery(query);
    	rt.next();
    	return rt.getBoolean(1);}
    	catch(SQLException s) {
    		System.err.println("Your booking number is invalid");
    	}
    	return false;
    }
    public void cancelation() {
    	try{
    		System.out.println("Enter the booking number");
    	int bookingno=scan.nextInt();
    if(checkingbookingno(bookingno)) {
    	Connection con =DBconnection.getConnection();
     	String query ="delete from booking where bookingno ="+bookingno;
     	Statement st =con.createStatement();
     	st.executeUpdate(query);
    	System.out.println("Your booking is canceled");
    	con.close();
    }
    else {
    	System.out.println("Enter the correct booking number");
    }
     }
    	catch(NoSuchElementException |SQLException s) {
    		System.err.println("Enter the correct values");			
    }}
    boolean checkingDistrict(String from,String to) {
    	try{Connection con =DBconnection.getConnection();
    	String query1="select exists(select sno from District where districtName=?)";
    	
    	String query2="select exists(select sno from District where districtName=?)";
    	PreparedStatement pst1 =con.prepareStatement(query1);
    	PreparedStatement pst2 =con.prepareStatement(query2);
    	pst1.setString(1,from);
    	pst2.setString(1,to);
    	ResultSet rt1 =pst1.executeQuery();
    	ResultSet rt2 =pst2.executeQuery();
    	rt1.next();
    	rt2.next();
    	if(rt1.getBoolean(1)&&rt2.getBoolean(1)) {
    		return true;
    	}
    	return false;
    }
    catch(SQLException s) {
		System.err.println("Error occured");	
		return false;
}
    	
    	}}