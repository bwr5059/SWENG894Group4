/*---------------------------------------------------------------------
|  Class UserService
|
|  Purpose: Define User Services to be Implemented
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.util.List;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Ballot;

/**
 * UserService Class - Interface for UserService.
 */
public interface UserService {
	
	//Retrieves all Rows from User Table
	List<User> findAllUsers(); 
	
	//Returns a user by ID
	User findById(String id);
	
	//Adds a user to the system
	void addUser(User user, String type);
	
	//Updates a user in the system
	void updateUser(User user);
	
	//Updates a user's permission
	void updateUserType(String id, String type);
	
	//Deletes a user by ID
	void deleteUserById(String id);
	
	//Adds a question to a candidate
	void addQuestion(Question question);
	
	//Casts a Candidate Selection Vote
	Ballot castVote(String type, Ballot ballot);
	
	//Updates an existing Vote
	Ballot updateVote(int, electionID, String userID, Ballot ballot);
	
}
