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
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;

/**
 * CandidateService Class - Interface for CandidateService.
 */
public interface CandidateService {
	
	//Retrieves all Rows from Candidate Table
	List<Candidate> findAllCandidates(); 
	
	//Returns a candidate by ID
	Candidate findById(String canID);
	
	//Returns a candidate by name
	Candidate findByName(String name);
	
	//Adds a candidate profile
	String addCandidate(Candidate candidate);
	
	//Updates a candidate in the system
	void updateCandidate(Candidate candidate);
	
	//Answers a voter question
	void answerQuestion(Question question, int qID);
	
	
}