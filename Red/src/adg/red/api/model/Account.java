package adg.red.api.model;

import adg.red.api.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Account {
	
	private Connection _conn;
	
	public Account(){
		_conn = Database.dbConnect(Database.CONNECT_URL, Database.USER_ID, Database.PASSWORD);
	}

	public PreparedStatement getValidateAccountSql(int bid) throws SQLException
	{
		PreparedStatement ps = _conn.prepareStatement("SELECT FROM branch WHERE branch_id = ?");
		ps.setInt(1, bid);
		return ps;
	}
	
	public void executeSql(PreparedStatement ps)
	{
		try
		{
			_conn.commit();
			ps.close();
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());

			try 
			{
				_conn.rollback();	
			}
			catch (SQLException ex2)
			{
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
	}
	
	public void addAccount(int bid) throws SQLException
	{
		executeSql(getValidateAccountSql(bid));
	}

        // action login
        private String getLoginSql(String uid)
	{
		String sql = "SELECT * FROM user WHERE username=\"";
		sql += uid;
                sql += "\"";
		return sql;
	}

	public int executeLoginSql(String uid, String pwd)
	{
            String sql = getLoginSql(uid);
            int returnResult = -4;
		Statement  stmt;
		ResultSet  rs;
		try
		{
			stmt = _conn.createStatement();
			rs = stmt.executeQuery(sql);
                        if (rs != null)
                        {
                            if (rs.getRow() == 0)
                            {
                                returnResult = -1;
                            }
                            while(rs.next())
                            {
                                String returnPwd = rs.getString("password");
                                if (!returnPwd.equals(pwd))
                                {
                                    returnResult = -2;
                                }
                                else
                                {
                                    if (rs.getInt("isOnline")==0)
                                    {
                                        returnResult = rs.getInt("usertypeid");
                                    }
                                    else
                                    {
                                        returnResult = -3;
                                    }
                                }
                            }
                        }
			stmt.close();
			return returnResult;
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
		}
            return returnResult;
	}
}
