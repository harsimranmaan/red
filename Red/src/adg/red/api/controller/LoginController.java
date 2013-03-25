package adg.red.api.controller;

import adg.red.api.model.Account;
import adg.red.api.util.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginController{
	

	public LoginController(){
            
	}
	
	/**
	 * the following function is for exampling method only
	 * @throws SQLException 
	 */
        
        // given a user id: uid and a user password: pwd, it returns a user type.
        // 0 means student, 1 means faculty, 2 means admin
        // -1 means no user id, -2 means wrong pwd, -3 means another connection with the same account is online
        // -4 means database connection error
        public int login(String uid, String pwd) throws SQLException
        {
            Account account = new Account();
            return account.executeLoginSql(uid, pwd);
        }
}

