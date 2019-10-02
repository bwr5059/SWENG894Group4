/*---------------------------------------------------------------------
|  Class CandidateService
|
|  Purpose: Define Candidate Services to be Implemented
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.util.List;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;

/**
 * CandidateService Class - Interface for CandidateService.
 */
public interface CandidateService {
	
	//Retrieves all Rows from Candidate Table
	List<Candidate> findAllCandidates(); 
	
	//Adds a candidate profile
	String addCandidate(Candidate candidate);
	
	
}