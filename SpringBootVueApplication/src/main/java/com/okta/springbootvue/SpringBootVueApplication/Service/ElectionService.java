/*---------------------------------------------------------------------
|  Class ElectionService
|
|  Purpose: Define Election Services to be Implemented
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.util.List;
import java.util.HashMap;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;

/**
 * ElectionService Class - Interface for ElectionService.
 */
public interface ElectionService {
	//Retrieves all Rows from User Table
	List<Election> findAllElections(); 
	
	//Returns an election by ID
	Election findElectionById(int electionID);
	
	//Adds an election to the system
	void addElection(Election election);
		
	//Updates an election in the system
	void updateElection(Election election);
		
	//Deletes an election by ID
	void deleteElectionById(int electionID);
	
	//Adds user's voter permissions to an election
	void associateVoter(int electionID, String id);
	
	//Removes user as a voter in an election
	void withdrawVoter(int electionID, String id);
	
	//Validates user as a voter in an election
	String validateVoter(int electionID, String id);
		
	//Adds user as a candidate in an election
	void associateCandidate(int electionID, String id);
	
	//Removes user as a candidate in an election
	void withdrawCandidate(int electionID, String id);
	
	//Validates user as a Candidate in an election
	String validateCandidate(int electionID, String id);
	
	//View Candidates by Election
	List<HashMap<String, String>> viewCandidates(int electionID);
	
	//Returns a policy by ID
	Policy getPolicy(int electionID);
	
	//Create new Election Policy
	void createPolicy(Policy policy);
	
	//Modify Existing Election Policy
	void modifyPolicy(Policy policy);
		
}
