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

  private final UserRepository repository;
  @Autowired
  UserService userService;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

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
  public ResponseEntity<User> getUser(@PathVariable("id") long id) {
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
  @PutMapping("/users/modify/{id}")
  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(user -> {
	        user.setFirstName(newUser.getFirstName());
	        user.setLastName(newUser.getLastName());
	        user.setType(newUser.getType());
	        user.setAge(newUser.getAge());
	        user.setEthnicity(newUser.getEthnicity());
	        user.setRace(newUser.getRace());
	        user.setGender(newUser.getGender());
	        user.setAddress(newUser.getAddress());
	        user.setCity(newUser.getCity());
	        user.setState(newUser.getState());
	        user.setZip(newUser.getZip());
	        return repository.save(user);
	      })
	      .orElseGet(() -> {
	        newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }

  //Remove one user
  @DeleteMapping("/users/remove/{id}")
  void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }
}