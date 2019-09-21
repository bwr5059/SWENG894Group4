package src.main.java.com.okta.springbootvue.SpringBootVueApplication;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  //Get all users
  @GetMapping("/users")
  List<User> all() {
    return repository.findAll();
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

  //Get one user
 @GetMapping("/users/{id}")
 User one(@PathVariable Long id) {

   return repository.findById(id)
     .orElseThrow(() -> new UserNotFoundException(id));
 }
  
  //Add New User - Register
  @PostMapping("/users/addProfile/{type}")
  User newUser(@RequestBody User newUser, @PathVariable String type) {
	  if(type.equals("Candidate")) {
		  newUser.setType("Candidate");
	  }else {
		  newUser.setType("Voter");
	  }
	  
      return repository.save(newUser);
  }

  //Remove one user
  @DeleteMapping("/users/remove/{id}")
  void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
