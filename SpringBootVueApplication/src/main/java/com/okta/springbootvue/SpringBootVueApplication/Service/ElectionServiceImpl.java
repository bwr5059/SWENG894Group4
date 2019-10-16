/*---------------------------------------------------------------------
|  Class ElectionServiceImpl
|
|  Purpose: Implementation of Election Services
|
|  Methods: findAllElections, findElectionById, addElection, updateElection,
|           deleteElectionById, associateVoter, associateCandidate, 
|           withdrawCandidate
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;

/**
 * ElectionServiceImpl Class - Implements ElectionService interface. Connects ElectionService class methods to database by
 * calling the connDao RetrieveConnection method and associated methods to execute statements.
 */
@Service("electionService")
public class ElectionServiceImpl implements ElectionService{
	
	//Complete List of Existing Elections
	private static List<Election> elections;
	private static List<Candidate> candidates;
	
	//Object to call all Election Queries
	ElectionConnectionDao connDao = new ElectionConnectionDao();

	/**
	 * findAllElections() - Retrieves all rows from election table.
	 * @return List<Election> elections
	 */
	public List<Election> findAllElections() {
		elections= connDao.getElectionList();
		return elections;
		
	}
	
	/**
	 * findElectionByID() - Finds and returns an election from the election table by ID. If election does not exist return null.
	 * @param electionID
	 * @return
	 */
	public Election findElectionById(int electionID) {
		Election election = connDao.getElectionById(electionID);
		return election;
	}
	
	/**
	 * addElection() - Adds an election to the election table.
	 * @param election
	 */
	public void addElection(Election election) {
		elections = findAllElections();
		connDao.insertElection(election, elections);
		elections.add(election);
	}
	
	/**
	 * updateElection() - Updates an existing election.
	 * @param election
	 */
	public void updateElection(Election election) {
		connDao.updateElection(election, elections);
	}
	
	/**
	 * deleteElectionByID() - Deletes an election from the database matching the electionID parameter.
	 * @param electionID
	 */
	public void deleteElectionById(int electionID) {
		connDao.deleteElection(electionID, elections);
	}
	
	/**
	 * associateVoter() - Adds a userID and associated electionID to the vote authorization database table.
	 * @param electionID
	 * @param id
	 */
	public void associateVoter(int electionID, String id) {	
		connDao.insertVoteAuth(electionID, id);
	}
	
	/**
	 * withdrawVoter() - Removes an userID and associated electionID to the voteAuthorization database table.
	 * @param electionID
	 * @param id
	 */
	public void withdrawVoter(int electionID, String id) {
		connDao.removeVoteAuth(electionID, id);
	}
	
	/**
	 * associateCandidate() - Adds an userID and associated electionID to the electionDandidate database table.
	 * @param electionID
	 * @param id
	 */
	public void associateCandidate(int electionID, String id) {
		connDao.insertElectionCandidate(electionID, id);
	}
	
	/**
	 * withdrawCandidate() - Removes an userID and associated electionID to the electionCandidate database table.
	 * @param electionID
	 * @param id
	 */
	public void withdrawCandidate(int electionID, String id) {
		connDao.removeElectionCandidate(electionID, id);
	}
	
	/**
	 * viewCandidates() -
	 * @param electionID
	*/
	public List<Candidate> viewCandidates(int electionID) {
		candidates= connDao.getCandidatesByElection(electionID);
		return candidates;
		
	}
	
	/**
	 * createPolicy() - Adds a policy to the electionPolicy table.
	 * @param election
	 */
	public void createPolicy(Policy policy) {
		connDao.insertPolicy(policy);
	}
	
	/**
	 * modifyPolicy() - Adds a policy to the electionPolicy table.
	 * @param election
	 */
	public void modifyPolicy(Policy policy) {
		connDao.updatePolicy(policy);
	}
	

}
