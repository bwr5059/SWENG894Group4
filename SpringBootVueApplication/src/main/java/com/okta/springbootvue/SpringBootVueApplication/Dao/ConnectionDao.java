/*---------------------------------------------------------------------
|  Class ConnectionDao
|
|  Purpose: Establishes and Closes Database Connections
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ConnectionDao Class - Connects to MySQL database vision-database
 */
public class ConnectionDao {
	//Connection con = null;
	
	/**
	 * RetrieveConnection() - Establishes and returns a connection to the MYSQL database.
	 * @return con
	 */
	public Connection RetrieveConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://vision-database.cmhohrk4u5fw.us-east-2.rds.amazonaws.com:3306/vision_database","admin","visionelection19");
			}catch(Exception e){ 
				System.out.println(e);
			}
		return con;  
	}
	
	/**
	 * ReleaseConnection() - Closes connection to the MYSQL database.
	 * @return con
	 */
	public void ReleaseConnection(Connection con) {
		try {
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}