package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;


class ElectionNotFoundException extends RuntimeException {

  ElectionNotFoundException(Long electionId) {
    super("Could not find election " + electionId);
  }
}