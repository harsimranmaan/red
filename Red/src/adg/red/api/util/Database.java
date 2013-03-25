package adg.red.api.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database 
{
    /*
	public static String USER_ID = "root";
	public static String PASSWORD = "";
	public static String CONNECT_URL = "jdbc:mysql://localhost/REDTEST"; 
*/	
        
        public static String USER_ID = "adgred";
	public static String PASSWORD = "red";
	public static String CONNECT_URL = "jdbc:mysql://ec2-50-18-66-213.us-west-1.compute.amazonaws.com/AdgDevelopment"; 
        
	public Database() {}

	public static void dbRegister()
	{
		try 
		{
			// Load the MySQL JDBC driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			System.exit(-1);
		}
	}
	
	public static Connection dbConnect(String db_connect_string, 
			String db_userid, String db_password)
	{
		dbRegister();
		
		try
		{
			Connection conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
			System.out.println("db connected");
			return conn;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
