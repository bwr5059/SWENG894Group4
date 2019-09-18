package src.main.java.com.okta.springbootvue.SpringBootVueApplication;


class UserNotFoundException extends RuntimeException {

  UserNotFoundException(Long id) {
    super("Could not find user " + id);
  }
}