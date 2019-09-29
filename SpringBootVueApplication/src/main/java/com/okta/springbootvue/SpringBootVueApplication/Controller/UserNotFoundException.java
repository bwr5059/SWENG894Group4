package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;


class UserNotFoundException extends RuntimeException {

  UserNotFoundException(Long id) {
    super("Could not find user " + id);
  }
}