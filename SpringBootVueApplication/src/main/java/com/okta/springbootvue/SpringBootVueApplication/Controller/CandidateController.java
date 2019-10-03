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
	 * newCandidate() - Receives a Candidate object. Calls the addCandidate method of candidateService. Returns a candidate.
	 * @param candidate
	 * @return 
	 */
	@PostMapping("/candidate/addCandidate")
	public ResponseEntity<Candidate> newCandidate(@RequestBody Candidate candidate) {
		
		candidateService.addCandidate(candidate);
		return new ResponseEntity<Candidate>(candidate, HttpStatus.CREATED);
	}
    
}
