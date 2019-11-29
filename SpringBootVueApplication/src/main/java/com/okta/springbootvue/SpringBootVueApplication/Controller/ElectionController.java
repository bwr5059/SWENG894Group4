/*---------------------------------------------------------------------
|  Class ElectionController
|
|  Purpose: Set up Election REST Endpoints
|
|  Methods: listAllElections, getElection, newElection, modifyElection,
|           deleteElection, associateVoter, associateCandidate, 
|           removeCandidate, viewCandidates
|
|  Version: Sprint 2
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
//import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ArrayList;
import java.util.ArrayList;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao;
//import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.String;
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

		electionService.calculateClosed(electionID);

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
	public ResponseEntity<Election> modifyElection(@PathVariable int electionID, @RequestBody Election election) {
		
		Election currentElection = electionService.findElectionById(electionID);
	  
		if (currentElection==null) {
			return new ResponseEntity<Election>(HttpStatus.NOT_FOUND);
		}  
		
		//Populate currentElection object from submitted object
		currentElection.setElectionID(electionID);
		currentElection.setTitle(election.getTitle());
		currentElection.setClosed(election.getClosed());
		currentElection.setClose_date(election.getClose_date());
		currentElection.setClose_time(election.getClose_time());
		currentElection.setNum_candidates(election.getNum_candidates());
		currentElection.setNum_votes(election.getNum_votes());
		currentElection.setStart_date(election.getStart_date());
		currentElection.setStart_time(election.getStart_time());
		currentElection.setDescription(election.getDescription());
		currentElection.setElection_key(election.getElection_key());
       
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
	 * removeVoter() - withdraw voter from registered election
	 * @param electionID
	 * @param userID
	 * @return ResponseEntity <Election>
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
	 * validateVoter () - Confirm voter is registed for election
	 * @param electionID
	 * @param userID
	 * @return String
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
	 * associateCandidate() - register candidate for an election 
	 * @param electionID
	 * @param id
	 * @return ResponseEntity<Election>
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
	 * validateCandidate() - Confirm candidate is registered for an election
	 * @param electionID
	 * @param userID
	 * @return String
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
	 * getPolicy () - View policy of an election
	 * @param electionID
	 * @return ResponseEntity<Policy>
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
	 * createPolicy() - Add a new policy for an election
	 * @param Policy
	 * @return ResponseEntity<Policy>
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
	 * modifyPolicy() - Modify an existing policy of an election
	 * @param Policy
	 * @return ResponseEntity<Policy>
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
	 * getVotesByVoter () - View Number of votes by user for an election
	 * @param electionID
	 * @param userID
	 * @return int number of votes
	**/
	@GetMapping("/election/getVotesByVoter/{electionID}/{userID}")
	public int getVotesByVoter(@PathVariable("electionID") int electionID, @PathVariable("userID") String userID) {
		int numVotes = 0;
		Election election = electionService.findElectionById(electionID);
		if (election == null) {
			return numVotes;
		}
		numVotes = electionService.getVotesByVoter(electionID, userID);
		return numVotes;
	}
	
	/**
	 * getLead () - 
	 * @param electionID
	 * @return 
	**/
	@GetMapping("/election/calculateLead/{electionID}")
	public ArrayList<String> getVotesByVoter(@PathVariable("electionID") int electionID) {
		ArrayList<String> leads = new ArrayList<String>();
		Election election = electionService.findElectionById(electionID);
		if (election == null) {
			return null;
		}
		leads = electionService.getLead(electionID);
		return leads;
	}
	
	/**
	 * getCandidateVotes() - Get number of votes for every candidate by candidate
	 * @param electionID
	 * @return HashMap<String,Integer>
	 */
	@GetMapping("/election/getCandidateVotes/{electionID}")
	public HashMap<String, Integer> getCandidateVotes(@PathVariable("electionID") int electionID) {
		HashMap<String,Integer> map =
				new HashMap<String, Integer>();

		Election election = electionService.findElectionById(electionID);

		if (election == null) {
			return  map;
		}

		map = electionService.tallyVotes(electionID);

		return map;
	}
	
	/**
	 * getChances() - 
	 * @param electionID
	 * @return HashMap<String,Integer>
	 */
	@GetMapping("/election/getChances/{electionID}")
	public HashMap<String, Float> getChances(@PathVariable("electionID") int electionID) {
		HashMap<String,Float> map =
				new HashMap<String,Float>();

		Election election = electionService.findElectionById(electionID);

		if (election == null) {
			return  map;
		}

		map = electionService.getChances(electionID);

		return map;
	}
  
}
