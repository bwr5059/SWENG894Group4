package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;

/**
 * Class UserNotFoundException - Provides exception if an user cannot be found by userID in the user
 * database table.
 */
class UserNotFoundException extends RuntimeException {

  UserNotFoundException(Long id) {
    super("Could not find user " + id);
  }
}