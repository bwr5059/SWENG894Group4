package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

public class ConnectionDao {
	Connection con = null;
	public Connection RetriveConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:mysql://vision-database.cmhohrk4u5fw.us-east-2.rds.amazonaws.com:3306/vision_database","admin","visionelection19");
		}catch(Exception e){ System.out.println(e);}
	return con;  
	}
	
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
			user.setUser_name(rs.getString(3));
			user.setFirst_name(rs.getString(4));
			user.setLast_name(rs.getString(5));
			user.setType(rs.getString(6));
			user.setAge(rs.getInt(7));
			user.setEthnicity(rs.getString(8));
			user.setGender(rs.getString(9));
			user.setProfile_complete(rs.getInt(10));
			user.setAddress(rs.getString(11));
			user.setCity(rs.getString(12));
			user.setState(rs.getString(13));
			user.setZip(rs.getString(14));
			userList.add(user);
		}
		System.out.println("list is: "+userList.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
		
	}
	
	public List<User> insertUser(Connection conn, User user, List<User> userList){
		if(conn == null) {
			conn = RetriveConnection();
		}

		try {
		String sql = "INSERT INTO user (id, email, user_name, first_name, last_name, type, age, ethnicity, gender, profile_complete, " +
				"address, city, state, zip) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1,user.getId());
		stmt.setString(2,user.getEmail());
		stmt.setString(3,user.getUser_name());
		stmt.setString(4,user.getFirst_name());
		stmt.setString(5,user.getLast_name());
		stmt.setString(6,user.getType());
		stmt.setInt(7,user.getAge());
		stmt.setString(8,user.getEthnicity());
		stmt.setString(9,user.getGender());
		stmt.setInt(10,user.getProfile_complete());
		stmt.setString(11,user.getAddress());
		stmt.setString(12,user.getCity());
		stmt.setString(13,user.getState());
		stmt.setString(14,user.getZip());
		
		stmt.executeUpdate();  
		
		/*User userNew = new User();
		userNew.setId(rs.getLong(1));
		userNew.setEmail(rs.getString(2));
		userNew.setFirstName(rs.getString(3));
		userNew.setLastName(rs.getString(4));
		userNew.setType(rs.getString(5));
		userNew.setAge(rs.getInt(6));
		userNew.setEthnicity(rs.getString(7));
		userNew.setRace(rs.getString(8));
		userNew.setGender(rs.getString(9));
		userNew.setProfileComplete(rs.getBoolean(10));
		userNew.setAddress(rs.getString(11));
		userNew.setCity(rs.getString(12));
		userNew.setState(rs.getString(13));
		userNew.setZip(rs.getInt(14));
		userList.add(user);*/
		
		System.out.println("list is: "+userList.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
		
	}

}
