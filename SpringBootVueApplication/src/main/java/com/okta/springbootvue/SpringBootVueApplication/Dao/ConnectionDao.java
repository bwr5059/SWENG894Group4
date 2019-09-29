package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

/**
 * ConnectionDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class ConnectionDao {
	Connection con = null;

	/**
	 * RetrieveConnection() - Establishes and returns a connection to the MYSQL database.
	 * @return con
	 */
	public Connection RetriveConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:mysql://vision-database.cmhohrk4u5fw.us-east-2.rds.amazonaws.com:3306/vision_database","admin","visionelection19");
		}catch(Exception e){ System.out.println(e);}
	return con;  
	}

	/**
	 * getUserList() - Performs select MySQL statement to retrieve all users from user table.
	 * @param conn
	 * @return List<User>
	 */
	public List<User> getUserList(Connection conn){
		if(conn == null) {
			conn = RetriveConnection();
		}
		List<User> userList = new ArrayList<>();
		try {
		Statement stmt=conn.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from user");  
		while(rs.next())  {
			User user = new User();
			user.setId(rs.getString(1));
			user.setEmail(rs.getString(2));
			user.setType(rs.getString(3));
			user.setAge(rs.getInt(4));
			user.setEthnicity(rs.getString(5));
			user.setGender(rs.getString(6));
			user.setAddress(rs.getString(7));
			user.setCity(rs.getString(8));
			user.setState(rs.getString(9));
			user.setZip(rs.getString(10));
			user.setFirst_name(rs.getString(11));
			user.setLast_name(rs.getString(12));
			user.setProfile_complete(rs.getInt(13));
			user.setUser_name(rs.getString(14));
			user.setRace(rs.getString(15));
			userList.add(user);
		}
		System.out.println("list is: "+userList.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
		
	}

	/**
	 * insertUser() - Inserts a new user row into the user database table using MySQL statement.
	 * @param conn
	 * @param user
	 * @param userList
	 * @return List<User>
	 */
	public List<User> insertUser(Connection conn, User user, List<User> userList){
		if(conn == null) {
			conn = RetriveConnection();
		}

		try {
		String sql = "INSERT INTO user (id, email, type, age, ethnicity, gender, address, city, state, zip, first_name, " +
				"last_name, profile_complete, user_name, race) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,user.getId());
		stmt.setString(2,user.getEmail());
		stmt.setString(3,user.getType());
		stmt.setInt(4,user.getAge());
		stmt.setString(5,user.getEthnicity());
		stmt.setString(6,user.getGender());
		stmt.setString(7,user.getAddress());
		stmt.setString(8,user.getCity());
		stmt.setString(9,user.getState());
		stmt.setString(10,user.getZip());
		stmt.setString(11,user.getFirst_name());
		stmt.setString(12,user.getLast_name());
		stmt.setInt(13,user.getProfile_complete());
		stmt.setString(14,user.getUser_name());
		stmt.setString(15,user.getRace());
		stmt.executeUpdate();  
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
		
	}

	/**
	 * updateUser() - Updates a user in the user database table with received values using MySQL statement.
	 * @param conn
	 * @param user
	 * @param userList
	 * @return List<User>
	 */
	public List<User> updateUser(Connection conn, User user, List<User> userList){
		if(conn == null) {
			conn = RetriveConnection();
		}

		try {
		String sql = "UPDATE user SET id=?, email=?, type=?, age=?, ethnicity=?, gender=?, address=?, city=?, state=?, zip=?, first_name=?, " +
				"last_name=?, profile_complete=?, user_name=?, race=? WHERE id=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,user.getId());
		stmt.setString(2,user.getEmail());
		stmt.setString(3,user.getType());
		stmt.setInt(4,user.getAge());
		stmt.setString(5,user.getEthnicity());
		stmt.setString(6,user.getGender());
		stmt.setString(7,user.getAddress());
		stmt.setString(8,user.getCity());
		stmt.setString(9,user.getState());
		stmt.setString(10,user.getZip());
		stmt.setString(11,user.getFirst_name());
		stmt.setString(12,user.getLast_name());
		stmt.setInt(13,user.getProfile_complete());
		stmt.setString(14,user.getUser_name());
		stmt.setString(15,user.getRace());
		stmt.setString(16,user.getId());
		stmt.executeUpdate();  
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
		
	}

	/**
	 * updateUserType() - Takes parameters userID and type. Updates user using MySQL statement.
	 * @param conn
	 * @param id
	 * @param type
	 */
	public void updateUserType(Connection conn, String id, String type){
		if(conn == null) {
			conn = RetriveConnection();
		}

		try {
		String sql = "UPDATE user SET type=? WHERE id=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,type);
		stmt.setString(2,id);
		stmt.executeUpdate();  
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		//con.close();  
		
	}

	/**
	 * deleteUser() - Takes parameters userID and uses MySQL statement to delete user by userID.
	 * @param conn
	 * @param Id
	 * @param userList
	 * @return
	 */
	public List<User> deleteUser(Connection conn, String Id, List<User> userList){
		if(conn == null) {
			conn = RetriveConnection();
		}

		try {
		String sql = "DELETE FROM user WHERE id=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,Id);
		stmt.executeUpdate();  
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
		
	}

}
