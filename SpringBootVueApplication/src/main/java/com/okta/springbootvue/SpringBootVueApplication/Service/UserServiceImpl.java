package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

/**
 * UserServiceImpl Class - Implements UserService interface. Connects UserService class methods to database by
 * calling the connDao RetrieveConnection method and associated methods to execute statements.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	ConnectionDao connDao = new ConnectionDao();
	Connection conn = null;
	
	static{
		//users = populateDummyUsers();
	}

	/**
	 * getConnection() - Calls the RetrieveConnection() method of ConnectionDao. Retrieves user using connection.
	 */
	public void getConnection() {
		conn = connDao.RetriveConnection();
		users= connDao.getUserList(conn);
	}

	/**
	 * findAllUsers() - Retrieves all rows from user table.
	 * @return
	 */
	public List<User> findAllUsers() {
		connDao.RetriveConnection();
		users= connDao.getUserList(conn);
		return users;
	}

	/**
	 * findByID() - Finds and returns a user from the user table by ID. If user does not exist return null.
	 * @param id
	 * @return
	 */
	//Find single user by id
	public User findById(String id) {
		users = findAllUsers();
		for(User user : users){
			if(user.getId().equals(id)){
				return user;
			}
		}
		return null;
	}

	/**
	 * findByEmail() - Finds and returns a user from the user table by email. If user does not exist return null.
	 * @param email
	 * @return
	 */
	//Find single user by email
	public User findByEmail(String email) {
		users = findAllUsers();
		for(User user : users){
			if(user.getEmail().equalsIgnoreCase(email)){
				return user;
			}
		}
		return null;
	}

	/**
	 * addUser() - Adds a user to the user table.
	 * @param user
	 * @param type
	 */
	//Add single user to db
	public void addUser(User user, String type) {
		users = findAllUsers();
		if(type.equals("Candidate")) {
		  user.setType("Candidate");
		 }else {
		  user.setType("Voter");
		}
		user.setProfile_complete(0);
		
		connDao.insertUser(conn, user, users);
		users.add(user);
	}

	/**
	 * updateUser() -
	 * @param user
	 */
	//Update existing user in db
	public void updateUser(User user) {
		connDao.updateUser(conn, user, users);
		
		/*users = findAllUsers();
		int index = users.indexOf(user);
		users.set(index, user);*/
	}

	/**
	 * updateUserType() - Takes a userID and type as parameters and updates the user table by userID.
	 * @param id
	 * @param type
	 */
	//Update existing user type in db
		public void updateUserType(String id, String type) {
			connDao.updateUserType(conn, id, type);
			
			/*users = findAllUsers();
			int index = users.indexOf(user);
			users.set(index, user);*/
		}

	/**
	 * deleteUserByID() -
	 * @param id
	 */
	//Delete single user in db
	public void deleteUserById(String id) {
		
		/*for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId().equals(id)) {
		        iterator.remove();
		    }
		}*/
		connDao.deleteUser(conn, id, users);
		
	}

	/**
	 * isUserExist() -
	 * @param user
	 * @return
	 */
	public boolean isUserExist(User user) {
		return findByEmail(user.getEmail())!=null;
	}

	/**
	 * deleteAllUsers() -
	 */
	public void deleteAllUsers(){
		users.clear();
	}

}
