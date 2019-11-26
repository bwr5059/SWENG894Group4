/*---------------------------------------------------------------------
|  Class ElectionServiceImpl
|
|  Purpose: Implementation of Election Services
|
|  Methods: findAllElections, findElectionById, addElection, updateElection,
|           deleteElectionById, associateVoter, associateCandidate, 
|           withdrawCandidate
|
|  Version: Sprint 2
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionHelperDao;
//import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.String;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Tree.DecisionTree;

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
	 * validateVoter() - Confirm voter is registered for election
	 * @param electionID
	 * @param id
	 */
	public String validateVoter(int electionID, String id) {
		return connDao.getVoteAuth(electionID, id);
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
	 * validateCandidate() - Confirm candidate if registered for an election
	 * @param electionID
	 * @param id
	 */
	public String validateCandidate(int electionID, String id) {
		return connDao.getElectionCandidate(electionID, id);
	}
	
	/**
	 * viewCandidates() - View candidates for an election
	 * @param electionID
	*/
	public List<HashMap<String, String>> viewCandidates(int electionID) {
		List<HashMap<String, String>> listofMaps = new ArrayList<HashMap<String, String>>();
		listofMaps= connDao.getCandidatesByElection(electionID);
		return listofMaps;
		
	}
	
	/**
	 * getPolicy() - View poilcy of an election
	 * @param electionID
	 * @return Policy
	 */
	public Policy getPolicy(int electionID) {
		Policy policy = connDao.getPolicy(electionID);
		return policy;
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
	
	/**
	 * getVotesByVoter() - Return number of votes a user has submitted for an election
	 * @param electionID
	 * @return int number of votes
	 */
	public int getVotesByVoter(int electionID, String userID) {
		int numVotes = connDao.getVotesByVoter(electionID, userID);
		return numVotes;
	}
	
	/**
	 * getLead() - 
	 * @param electionID
	 * @return 
	 */
	public ArrayList<String> getLead(int electionID) {
		ArrayList<String> leads = new ArrayList<String>(); 
		leads = connDao.getLead(electionID);
		return leads;
	}
	
	/**
	 * tallyVotes() - 
	 * @param electionID
	 */
	public HashMap<String, Integer> tallyVotes(int electionID) {
		ElectionHelperDao helperDao = new ElectionHelperDao();
		HashMap<String, Integer> listofMaps = new HashMap<String, Integer>();
		listofMaps= helperDao.tallyVotes(electionID);
		return listofMaps;
	}
	
	/**
	 * getChances() - 
	 * @param electionID
	 */
	public HashMap<String, Float> getChances(int electionID) {
		DecisionTree tree = new DecisionTree();
		HashMap<String, Float> listofMaps = new HashMap<String, Float>();
		listofMaps= tree.calculateChances(electionID);
		return listofMaps;
	}
	
}
