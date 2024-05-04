package busreservation;
import java.sql.*;
public class DBconnection {
	public static Connection getConnection() throws SQLException{
 String url ="jdbc:mysql://localhost:****(serveraddress)/busreservation";
 //we need to give the database server address and password to connect with MySQL database
 String username ="root";
 String password="****(Password)";

 Connection con =DriverManager.getConnection(url,username,password);
 return con;
	}
 
}
