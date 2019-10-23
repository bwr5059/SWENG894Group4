/*---------------------------------------------------------------------
|  Class ElectionController
|
|  Purpose: Set up Election REST Endpoints
|
|  Methods: listAllElections, getElection, newElection, modifyElection,
|           deleteElection, associateVoter, associateCandidate, 
|           removeCandidate, viewCandidates
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/
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
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionService;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService;

/**
 * Class ElectionController - Returns election object and data using CRUD methods.
 */
@RestController
public class ElectionController {
	
	@Autowired
	ElectionService electionService;
	
	@Autowired
	UserService userService;

	/**
     * listAllElections() - Calls findAllElections() method in electionService class. Returns election list response of
     * elections if not null.
     * @return new ResponseEntity<List<Election>>(elections, HttpStatus)
     *
    **/
	@GetMapping("/election")
	public ResponseEntity<List<Election>> listAllElections() {
		List<Election> elections = electionService.findAllElections();
		if(elections.isEmpty()){
			return new ResponseEntity<List<Election>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Election>>(elections, HttpStatus.OK);
	}
  
	/**
	 * getElection () - Calls findByID() method in electionService class, returns response containing election if electionID
	 * is found in database.
	 * @param electionID
	 * @return new ResponseEntity<Election>(election, HttpStatus)
	**/
	@GetMapping("/election/{electionID}")
	public ResponseEntity<Election> getElection(@PathVariable("electionID") int electionID) {
		Election election = electionService.findElectionById(electionID);
		if (election == null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Election>(election, HttpStatus.OK);
	}
  
  /**
   * newElection() - Takes an election object as a parameter and adds it to the database.
   * @param election
   * @return election
   */
	@PostMapping("/election/addElection")
	public ResponseEntity<Election> newElection(@RequestBody Election election) {
		/*if(userService.findById(election.getElectionID())!=null) {
			return new ResponseEntity<Election>(HttpStatus.CONFLICT); 
		}*/
		
		electionService.addElection(election);
		return new ResponseEntity<Election>(election, HttpStatus.CREATED);
	}

  /**
   * modifyElection() - Takes an election object and electionID and ,if ID is found in the database, updates election
   * table fields.
   * @param election
   * @param electionID
   * @return
   */
	@PutMapping("/election/modifyElection/{electionID}")
	public ResponseEntity<Election> modifyElection(@RequestBody Election election, @PathVariable int electionID) {
		
		Election currentElection = electionService.findElectionById(electionID);
	  
		if (currentElection==null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}  
	  
		//Populate currentElection object from submitted object
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
		currentElection.setDescription(election.getDescription());
       
		electionService.updateElection(currentElection);
		return new ResponseEntity<Election>(currentElection, HttpStatus.OK);
	    
	}
  
	/**
	 * deleteElection() - Takes an electionID, searches the database election table for ID, and deletes election if ID is found.
	 * @param electionID
	 * @return new ResponseEntity<Election>(HttpStatus)
	 */
	@DeleteMapping("/election/removeElection/{electionID}")
	public ResponseEntity<Election> deleteElection(@PathVariable("electionID") int electionID) {
		Election election = electionService.findElectionById(electionID);
		if (election == null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}
	 
		electionService.deleteElectionById(electionID);
		return new ResponseEntity<Election>(HttpStatus.OK);
	}
  
	/**
	 * associateVoter() - Takes and electionID and userID. If both values are found in database calls associateVoter method of
	 * electionService class to add user and election to authorization database table.
	 * @param electionID
	 * @param id
	 * @return
	 */
	@PostMapping("/election/associateVoter/{electionID}/{id}")
	public ResponseEntity<Election> associateVoter(@PathVariable("electionID") int electionID, @PathVariable("id") String id){
		Election election = electionService.findElectionById(electionID);
		User user = userService.findById(id);
	  
		if (election == null || user == null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}

		electionService.associateVoter(electionID, id);
		return new ResponseEntity<Election>(HttpStatus.OK);
	}
	
	/**
	 * removeVoter() - 
	 * @param 
	 * @param 
	 * @return
	 */
	@DeleteMapping("/election/withdrawVoter/{electionID}/{id}")
	public ResponseEntity<Election> removeVoter(@PathVariable("electionID") int electionID, @PathVariable("id") String id){
		Election election = electionService.findElectionById(electionID);
		User user = userService.findById(id);
	  
		if (election == null || user == null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}

		electionService.withdrawVoter(electionID, id);
		return new ResponseEntity<Election>(HttpStatus.OK);
	}
	
	/**
	 * validateVoter () - 
	 * @param 
	 * @return =
	**/
	@GetMapping("/election/validateVoter/{electionID}/{id}")
	public String validateVoter(@PathVariable("electionID") int electionID, @PathVariable("id") String id) {
		Election election = electionService.findElectionById(electionID);
		User user = userService.findById(id);
		
		if (election == null || user == null) {
			return "Election or User does not exist";
		}
		String result = electionService.validateVoter(electionID, id);
		return result;
	}
  
	/**
	 * getElectionType() - Takes an electionID and userID as parameters. If both are found in database, uses associateCandidate
	 * method of the electionService class to add userID and electionID to candidate database table.
	 * @param electionID
	 * @param id
	 * @return
	 */
	@PostMapping("/election/associateCandidate/{electionID}/{id}")
	public ResponseEntity<Election> associateCandidate(@PathVariable("electionID") int electionID, @PathVariable("id") String id){
		Election election = electionService.findElectionById(electionID);
		User user = userService.findById(id);
	  
		if (election == null || user == null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}

		electionService.associateCandidate(electionID, id);
		return new ResponseEntity<Election>(HttpStatus.OK);
	}
	
	/**
	 * removeCandidate() - Takes an electionID and userID as parameters. If both are found in database, uses withdrawCandidate
	 * method of the electionService class to delete userID and electionID from candidate database table.
	 * @param electionID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/election/withdrawCandidate/{electionID}/{id}")
	public ResponseEntity<Election> removeCandidate(@PathVariable("electionID") int electionID, @PathVariable("id") String id){
		Election election = electionService.findElectionById(electionID);
		User user = userService.findById(id);
	  
		if (election == null || user == null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}

		electionService.withdrawCandidate(electionID, id);
		return new ResponseEntity<Election>(HttpStatus.OK);
	}
	
	/**
	 * validateCandidate() - 
	 * @param 
	 * @return =
	**/
	@GetMapping("/election/validateCandidate/{electionID}/{id}")
	public String validateCandidate(@PathVariable("electionID") int electionID, @PathVariable("id") String id) {
		Election election = electionService.findElectionById(electionID);
		User user = userService.findById(id);
		
		if (election == null || user == null) {
			return "Election or User does not exist";
		}
		String result = electionService.validateCandidate(electionID, id);
		return result;
	}
	
	/**
	 * viewCandidates() - Takes an electionID as a parameter. View candidates by elections.
	 * @param electionID
	 * @return
	 */
	@GetMapping("/election/viewCandidates/{electionID}")
	public List<HashMap<String, String>> viewCandidates(@PathVariable("electionID") int electionID){ 
		Election election = electionService.findElectionById(electionID);
	  
		if (election == null) {
			//return new ResponseEntity<List<Candidate>>(HttpStatus.NOT_FOUND);
		}

		List<HashMap<String, String>> candidates = electionService.viewCandidates(electionID);
		//return new ResponseEntity<List<Candidate>>(candidates, HttpStatus.OK);
		return candidates;
	}
	
	/**
	 * getPolicy () - 
	 * @param 
	 * @return 
	**/
	@GetMapping("/election/getPolicy/{electionID}")
	public ResponseEntity<Policy> getPolicy(@PathVariable("electionID") int electionID) {
		Election election = electionService.findElectionById(electionID);
		if (election == null) {
			return new ResponseEntity<Policy>(HttpStatus.NOT_FOUND);
		}
		Policy policy = electionService.getPolicy(electionID);
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}
	
	/**
	 * createPolicy() - 
	 * @param 
	 * @param 
	 * @return
	 */
	@PostMapping("/election/createPolicy")
	public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy){
		Election election = electionService.findElectionById(policy.getElectionID());
	  
		if (election == null) {
			return new ResponseEntity<Policy>(HttpStatus.NOT_FOUND);
		}

		electionService.createPolicy(policy);
		return new ResponseEntity<Policy>(HttpStatus.OK);
	}
	
	/**
	 * modifyPolicy() - 
	 * @param 
	 * @param 
	 * @return
	 */
	@PutMapping("/election/modifyPolicy")
	public ResponseEntity<Policy> modifyPolicy(@RequestBody Policy policy){
		Election election = electionService.findElectionById(policy.getElectionID());
	  
		if (election == null) {
			return new ResponseEntity<Policy>(HttpStatus.NOT_FOUND);
		}

		electionService.modifyPolicy(policy);
		return new ResponseEntity<Policy>(HttpStatus.OK);
	}
	
	/**
	 * getVotesByVoter () - 
	 * @param 
	 * @return 
	**/
	@GetMapping("/election/getVotesByVoter/{electionID}/{userID}")
	public int getElection(@PathVariable("electionID") int electionID, @PathVariable("userID") String userID) {
		int numVotes = 0;
		Election election = electionService.findElectionById(electionID);
		if (election == null) {
			return numVotes;
		}
		numVotes = electionService.getVotesbyVoter(electionID, userID);
		return numVotes;
	}
  
}
