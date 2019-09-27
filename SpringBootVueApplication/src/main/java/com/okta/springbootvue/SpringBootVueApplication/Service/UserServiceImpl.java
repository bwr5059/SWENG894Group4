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

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	ConnectionDao connDao = new ConnectionDao();
	Connection conn = null;
	
	static{
		//users = populateDummyUsers();
	}
	
	public void getConnection() {
		conn = connDao.RetriveConnection();
		users= connDao.getUserList(conn);
	}

	//Select All Rows from User Table
	public List<User> findAllUsers() {
		connDao.RetriveConnection();
		users= connDao.getUserList(conn);
		return users;
	}
	
	public User findById(String id) {
		users = findAllUsers();
		for(User user : users){
			if(user.getId().equals(id)){
				return user;
			}
		}
		return null;
	}
	
	public User findByEmail(String email) {
		users = findAllUsers();
		for(User user : users){
			if(user.getEmail().equalsIgnoreCase(email)){
				return user;
			}
		}
		return null;
	}
	
	public void addUser(User user, String type) {
		users = findAllUsers();
		if(type.equals("Candidate")) {
		  user.setType("Candidate");
		 }else {
		  user.setType("Voter");
		}
		user.setProfile_complete(0);
		
		users.add(user);
		connDao.insertUser(conn, user, users);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(String id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId().equals(id)) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByEmail(user.getEmail())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

}
