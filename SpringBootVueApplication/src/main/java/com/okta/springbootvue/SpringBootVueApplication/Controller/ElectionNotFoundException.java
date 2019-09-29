package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;

/**
 * Class ElectionNotFoundException - Provides exception if an election cannot be found by electionID in the election
 * database table.
 */
class ElectionNotFoundException extends RuntimeException {

  ElectionNotFoundException(Long electionId) {
    super("Could not find election " + electionId);
  }
}