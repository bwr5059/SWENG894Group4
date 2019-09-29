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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import src.main.java.com.okta.springbootvue.SpringBootVueApplication;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService;

@RestController
public class UserController {

  //private final UserRepository repository;
  @Autowired
  UserService userService;

  //Return all Existing Users
  @GetMapping("/user/")
  public ResponseEntity<List<User>> listAllUsers() {
      List<User> users = userService.findAllUsers();
      if(users.isEmpty()){
          return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }
  
  //Return Single User by ID
  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") String id) {
      User user = userService.findById(id);
      if (user == null) {
          System.out.println("User with id " + id + " not found");
          return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<User>(user, HttpStatus.OK);
  }
  
  //Add New User
  @PostMapping("/user/addProfile/{type}")
  public User newUser(@RequestBody User user, @PathVariable String type) {

      userService.addUser(user, type);
      return user;
  }
  
  //Modify Existing User
  @PutMapping("/user/modifyProfile/{id}")
  public ResponseEntity<User> modifyUser(@RequestBody User user, @PathVariable String id) {
	  
	  User currentUser = userService.findById(id);
	  
	  if (currentUser==null) {
          System.out.println("User with id " + id + " not found");
          return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
      }  
	  
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
  
  //Modify Existing User Type
  @PutMapping("/user/addAdmin/{id}/{type}")
  public ResponseEntity<User> modifyUser(@PathVariable String id, @PathVariable String type) {
	  
	  User currentUser = userService.findById(id);
	  
	  if (currentUser==null) {
          System.out.println("User with id " + id + " not found");
          return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
      }  
       
      userService.updateUserType(id, type);
      return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	    
  }
  
  //Remove Existing User
  @DeleteMapping("/user/removeProfile/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
	  User user = userService.findById(id);
	  if (user == null) {
	      System.out.println("Unable to delete. User with id " + id + " not found");
	      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	  }
	 
	  userService.deleteUserById(id);
	  return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
  }
    
  
}
