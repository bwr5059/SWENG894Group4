package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;


class CandidateNotFoundException extends RuntimeException {

  CandidateNotFoundException(Long id) {
    super("Could not find user " + id);
  }
}