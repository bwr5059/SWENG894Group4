package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.util.List;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;

public interface ElectionService {
	//Retrieves all Rows from User Table
		List<Election> findAllElections(); 
		
		Election findById(int electionID);
		
		void addElection(Election election);
		
		void updateElection(Election election);
		
		void deleteElectionById(int electionID);
		
		void associateVoter(int electionID, String id);
		
		void associateCandidate(String id, String electionID);
		
}
