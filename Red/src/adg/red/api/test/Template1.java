package adg.red.api.test;

import adg.red.api.controller.LoginController;
import java.sql.SQLException;


public class Template1 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		LoginController login = new LoginController();
		System.out.println("Login return: " + login.login("nicole", "123456"));
	}

}
