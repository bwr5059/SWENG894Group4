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

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionService;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService;

@RestController
public class ElectionController {
	
	@Autowired
	ElectionService electionService;
	
	@Autowired
	UserService userService;

  //Return all existing elections
  @GetMapping("/election")
  public ResponseEntity<List<Election>> listAllElections() {
      List<Election> elections = electionService.findAllElections();
      if(elections.isEmpty()){
          return new ResponseEntity<List<Election>>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Election>>(elections, HttpStatus.OK);
  }
  
//Return Single Election by electionID
  @GetMapping("/election/{electionID}")
  public ResponseEntity<Election> getElection(@PathVariable("electionID") int electionID) {
      Election election = electionService.findById(electionID);
      if (election == null) {
          System.out.println("Election with id " + electionID + " not found");
          return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<Election>(election, HttpStatus.OK);
  }
  
  //Add New Election
  @PostMapping("/election/addElection")
  public Election newElection(@RequestBody Election election) {

      electionService.addElection(election);
      return election;
  }

  //Modify Existing Election
  @PutMapping("/election/modifyElection/{electionID}")
  public ResponseEntity<Election> modifyElection(@RequestBody Election election, @PathVariable int electionID) {
	  
	  Election currentElection = electionService.findById(electionID);
	  
	  if (currentElection==null) {
          System.out.println("Election with id " + electionID + " not found");
          return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
      }  
	  
	  currentElection.setElectionID(election.getElectionID());
	  currentElection.setTitle(election.getTitle());
	  currentElection.setClosed(election.getClosed());
	  currentElection.setAdmin1(election.getAdmin1());
	  currentElection.setAdmin2(election.getAdmin2());
	  currentElection.setAdmin3(election.getAdmin3());
	  currentElection.setAdmin4(election.getAdmin4());
	  currentElection.setAdmin5(election.getAdmin5());
	  currentElection.setAdmin6(election.getAdmin6());
	  currentElection.setChoice1(election.getChoice1());
	  currentElection.setChoice2(election.getChoice2());
	  currentElection.setChoice3(election.getChoice3());
	  currentElection.setChoice4(election.getChoice4());
	  currentElection.setChoice5(election.getChoice5());
	  currentElection.setClose_date(election.getClose_date());
	  currentElection.setClose_time(election.getClose_time());
	  currentElection.setNum_candidates(election.getNum_candidates());
	  currentElection.setNum_votes(election.getNum_votes());
	  currentElection.setStart_date(election.getStart_date());
	  currentElection.setStart_time(election.getStart_time());
       
      electionService.updateElection(currentElection);
      return new ResponseEntity<Election>(currentElection, HttpStatus.OK);
	    
  }
  
  //Remove Existing Election
  @DeleteMapping("/election/removeElection/{electionID}")
  public ResponseEntity<Election> deleteUser(@PathVariable("electionID") int electionID) {
	  Election election = electionService.findById(electionID);
	  if (election == null) {
	      System.out.println("Unable to delete. Election with id " + electionID + " not found");
	      return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
	  }
	 
	  electionService.deleteElectionById(electionID);
	  return new ResponseEntity<Election>(HttpStatus.NO_CONTENT);
  }
  
  //Associate a Voter
  @PostMapping("/election/associateVoter/{electionID}/{id}")
  public ResponseEntity<Election> getElection(@PathVariable("electionID") int electionID, @PathVariable("id") String id){
	  Election election = electionService.findById(electionID);
	  User user = userService.findById(id);
	  
	  if (election == null || user == null) {
          System.out.println("Election or User not found.");
          return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
      }

      electionService.associateVoter(electionID, id);
      return new ResponseEntity<Election>(HttpStatus.NO_CONTENT);
  }
  
  //Associate a Candidate
  @PostMapping("/election/associateCandidate/{electionID}/{id}")
  public ResponseEntity<Election> getElection(@PathVariable("electionID") int electionID, @PathVariable("id") String id){
	  Election election = electionService.findById(electionID);
	  User user = userService.findById(id);
	  
	  if (election == null || user == null) {
          System.out.println("Election or User not found.");
          return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
      }

      electionService.associateCandidate(electionID, id);
      return new ResponseEntity<Election>(HttpStatus.NO_CONTENT);
  }
  
}
