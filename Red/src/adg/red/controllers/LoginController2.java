import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginController {
	
	public LoginController(){
		
	}
	
	/**
	 * the following function is for exampling method only
	 * @throws SQLException 
	 */
	public void showAccount(int uid) throws SQLException{
		Connection conn = Database.dbConnect(Database.CONNECT_URL, Database.USER_ID, Database.PASSWORD);
		Account account = new Account(conn);
		account.showAccount(uid);
	}
}
