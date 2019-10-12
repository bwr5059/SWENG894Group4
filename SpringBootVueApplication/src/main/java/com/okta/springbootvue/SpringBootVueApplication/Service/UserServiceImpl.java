/*---------------------------------------------------------------------
|  Class UserServiceImpl
|
|  Purpose: Implementation of User Services
|
|  Methods: findAllUsers, findById, addUser, updateUser, updateUserType,
|           deleteUserById
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import org.springframework.stereotype.Service;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * UserServiceImpl Class - Implements UserService interface. Connects UserService class methods to database by
 * calling the connDao RetrieveConnection method and associated methods to execute statements.
 */
@Service("userService")
public class UserServiceImpl implements src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	UserConnectionDao connDao = new UserConnectionDao();
	Connection conn = null;

	/**
	 * findAllUsers() - Retrieves all rows from user table.
	 * @return User List
	*/
	public List<User> findAllUsers() {
		users= connDao.getUserList();
		return users;
	}
	
	/**
	 * findByID() - Finds and returns a user from the user table by ID. If user does not exist return null.
	 * @param id
	 * @return User
	*/
	public User findById(String id) {
		User user = connDao.getUserById(id);
		return user;
	}
	
	/**
	 * addUser() - Adds a user to the user table.
	 * @param user
	 * @param type
	*/
	public void addUser(User user, String type) {
		users = findAllUsers();
		if(type.equals("Candidate")) {
		  user.setType("Candidate");
		 }else {
		  user.setType("Voter");
		}
		user.setProfile_complete(0);
		
		connDao.insertUser(user, users);
		users.add(user);
	}

	/**
	 * updateUser() -Modify an existing user
	 * @param user
	*/
	public void updateUser(User user) {
		connDao.updateUser(user, users);
	}
	
	/**
	 * updateUserType() - Takes a userID and type as parameters and updates the user table by userID.
	 * @param id
	 * @param type
	 */
	public void updateUserType(String id, String type) {
		connDao.updateUserType(id, type);
	}

	/**
	 * deleteUserByID() -
	 * @param id
	*/
	public void deleteUserById(String id) {
		connDao.deleteUser(id, users);
		
	}

}
