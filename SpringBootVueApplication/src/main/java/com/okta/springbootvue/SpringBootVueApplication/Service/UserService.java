package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.util.List;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

public interface UserService {
	
	//Retrieves all Rows from User Table
	List<User> findAllUsers(); 
	
	User findById(String id);
	
	User findByEmail(String email);
	
	void addUser(User user, String type);
	
	void updateUser(User user);
	
	void deleteUserById(String id);
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
