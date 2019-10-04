/*---------------------------------------------------------------------
|  Class CandidateController
|
|  Purpose: Set up Candidate REST Endpoints
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


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import src.main.java.com.okta.springbootvue.SpringBootVueApplication;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.CandidateConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.CandidateService;

/**
 * Class CandidateController - Returns candidate object and data using CRUD methods.
 */
@RestController
public class CandidateController {

	//CandidateController calls CandidateService
	@Autowired
	CandidateService candidateService;


	/**
   	* listAllCandidates() - Calls findAllCandidates() method in candidateService class to return a list of all current candidate profiles in the system.
   	* @return
   	*/
	@GetMapping("/candidate/")
	public ResponseEntity<List<Candidate>> listAllCandidates() {
		List<Candidate> candidates = candidateService.findAllCandidates();
		if(candidates.isEmpty()){
			return new ResponseEntity<List<Candidate>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Candidate>>(candidates, HttpStatus.OK);
	}	
	
	/**
	 * getCandidate () - Calls findByID() method in candidateService class, returns response containing candidate if id
	 * is found in database.
	 * @param id
	 * @return new ResponseEntity<Election>(candidate, HttpStatus)
	**/
	@GetMapping("/candidate/{canID}")
	public ResponseEntity<Candidate> getCandidate(@PathVariable("canID") String canID) {
		Candidate candidate = candidateService.findById(canID);
		if (candidate == null) {
			System.out.println("DID NOT FIND");
			return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}
	
	/**
	 * getCandidateName () - Calls findByID() method in candidateService class, returns response containing candidate if id
	 * is found in database.
	 * @param id
	 * @return new ResponseEntity<Election>(candidate, HttpStatus)
	**/
	@GetMapping("/candidate/name/{name}")
	public ResponseEntity<Candidate> getCandidateName(@PathVariable("name") String name) {
		Candidate candidate = candidateService.findByName(name);
		if (candidate == null) {
			return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}
  
	/**
	 * newCandidate() - Receives a Candidate object. Calls the addCandidate method of candidateService. Returns a candidate.
	 * @param candidate
	 * @return 
	 */
	@PostMapping("/candidate/addCandidate")
	public ResponseEntity<Candidate> newCandidate(@RequestBody Candidate candidate) {
		
		candidateService.addCandidate(candidate);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.CREATED);
	}
	
	/**
	   * modifyCandidate() - Takes a candidate object and canID and ,if ID is found in the database, updates candidate
	   * table fields.
	   * @param candidate
	   * @param canID
	   * @return
	   */
		@PutMapping("/candidate/modifyCandidate/{canID}")
		public ResponseEntity<Candidate> modifyCandidate(@RequestBody Candidate candidate, @PathVariable String canID) {
			
			Candidate currentCandidate = candidateService.findById(canID);
		  
			if (currentCandidate==null) {
				return new ResponseEntity<Candidate>(HttpStatus.NOT_FOUND);
			}  
		  
			//Populate currentElection object from submitted object
			currentCandidate.setCanID(candidate.getCanID());
			currentCandidate.setUserID(candidate.getUserID());
			currentCandidate.setFirst_name(candidate.getFirst_name());
			currentCandidate.setLast_name(candidate.getLast_name());
			currentCandidate.setEmail(candidate.getEmail());
			currentCandidate.setElectionID(candidate.getElectionID());
			currentCandidate.setAbout(candidate.getAbout());
			currentCandidate.setEducation(candidate.getEducation());
			currentCandidate.setEmployment(candidate.getEmployment());
			currentCandidate.setExperience(candidate.getExperience());
			currentCandidate.setContact(candidate.getContact());
	       
			candidateService.updateCandidate(currentCandidate);
			return new ResponseEntity<Candidate>(currentCandidate, HttpStatus.OK);
		    
		}
    
}