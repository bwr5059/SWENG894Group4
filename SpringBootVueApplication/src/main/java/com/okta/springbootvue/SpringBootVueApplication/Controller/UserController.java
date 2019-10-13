/*---------------------------------------------------------------------
|  Class UserController
|
|  Purpose: Set up User REST Endpoints
|  
|  Methods: listAllUsers, getUser, newUser, modifyUser, deleteUser
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService;

/**
 * Class UserController - Returns user object and data using CRUD methods.
 */
@RestController
public class UserController {

	//UserController calls UserService
	@Autowired
	UserService userService;

	/**
   	* listAllUsers() - Calls findAllUsers() method in userService class to return a list of all current users in the system.
   	* @return
   	*/
	@GetMapping("/user/")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}	
  
	/**
	 * getUser() - Receives a userID parameter. Calls the findByID() method of user service, if found returns a user by specified ID.
	 * @param id
	 * @return
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
  
	/**
	 * newUser() - Receives a User object and type as parameters. Calls the addUser method of userService. Returns a user.
	 * @param user
	 * @param type
	 * @return 
	 */
	@PostMapping("/user/addProfile/{type}")
	public ResponseEntity<User> newUser(@RequestBody User user, @PathVariable String type) {
		if(userService.findById(user.getId())!=null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT); 
		}
		
		userService.addUser(user, type);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
  
	/**
	 * modifyUser() - Receives a User Object and a userID as parameters. If user exists in the system, modifies user
	 * information.
	 * @param user
	 * @param id
	 * @return
	 */
	@PutMapping("/user/modifyProfile/{id}")
	public ResponseEntity<User> modifyUser(@RequestBody User user, @PathVariable String id) {
	  
		User currentUser = userService.findById(id);
	  
		if (currentUser==null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}  
	  
		//Populate currentUser with submitted user
		currentUser.setId(user.getId());
		currentUser.setEmail(user.getEmail());
		currentUser.setType(user.getType());
		currentUser.setAge(user.getAge());
		currentUser.setEthnicity(user.getEthnicity());
		currentUser.setGender(user.getGender());
		currentUser.setAddress(user.getAddress());
		currentUser.setCity(user.getCity());
		currentUser.setState(user.getState());
		currentUser.setZip(user.getZip());
		currentUser.setFirst_name(user.getFirst_name());
		currentUser.setLast_name(user.getLast_name());
		currentUser.setProfile_complete(user.getProfile_complete());
		currentUser.setUser_name(user.getUser_name());
		currentUser.setRace(user.getRace());
       
		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	    
	}
  
	/**
	 * modifyUserType() - Takes a userID and type as parameters. If userID is found in the system, modifies the type field
	 * in the user database table.
	 * @param id
	 * @param type
	 * @return
	 */
	@PutMapping("/user/addAdmin/{id}/{type}")
	public ResponseEntity<User> modifyUserType(@PathVariable String id, @PathVariable String type) {
	  
		User currentUser = userService.findById(id);
	  
		if (currentUser==null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}  
       
		userService.updateUserType(id, type);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	    
	}
  
	/**
	 * deleteUser() - Takes a userID as a parameter, deletes user from user database table if userID exists in system.
	 * @param id
	 * @return
	 */
	@DeleteMapping("/user/removeProfile/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	 
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

	}
    
}