package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.util.List;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;

/**
 * ElectionService Class - Interface for ElectionService.
 */
public interface ElectionService {
	//Retrieves all Rows from User Table
		List<Election> findAllElections(); 

		//Returns an election by ID
		Election findById(int electionID);

		//Adds an election to the system
		void addElection(Election election);

		//Updates an election in the system
		void updateElection(Election election);

		//Deletes an election by ID
		void deleteElectionById(int electionID);

		//Adds user's voter permissions to an election
		void associateVoter(int electionID, String id);

		//Adds user as a candidate in an election
		void associateCandidate(int electionID, String id);
		
}
