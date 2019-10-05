/*---------------------------------------------------------------------
|  Class ElectionServiceImpl
|
|  Purpose: Implementation of Election Services
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

/**
 * ElectionServiceImpl Class - Implements ElectionService interface. Connects ElectionService class methods to database by
 * calling the connDao RetrieveConnection method and associated methods to execute statements.
 */
@Service("electionService")
public class ElectionServiceImpl implements ElectionService{
	
	//Complete List of Existing Elections
	private static List<Election> elections;
	
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
	 * findByID() - Finds and returns an election from the election table by ID. If election does not exist return null.
	 * @param electionID
	 * @return
	 */
	public Election findById(int electionID) {
		elections = findAllElections();
		for(Election election : elections){
			if(election.getElectionID() == electionID){
				return election;
			}
		}
		return null;
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
	

}
