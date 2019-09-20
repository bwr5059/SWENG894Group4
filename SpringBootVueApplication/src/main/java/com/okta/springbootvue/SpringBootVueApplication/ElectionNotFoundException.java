package src.main.java.com.okta.springbootvue.SpringBootVueApplication;


class ElectionNotFoundException extends RuntimeException {

  ElectionNotFoundException(Long electionId) {
    super("Could not find election " + electionId);
  }
}