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
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Election> elections;
	
	ElectionConnectionDao connDao = new ElectionConnectionDao();
	Connection conn = null;
	
	static{
		//users = populateDummyUsers();
	}

	/**
	 * getConnection() - Calls the RetrieveConnection() method of ElectionConnectionDao. Retrieves election using connection.
	 */
	public void getConnection() {
		conn = connDao.RetriveConnection();
		elections= connDao.getElectionList(conn);
	}

	/**
	 * findAllElections() - Retrieves all rows from election table.
	 * @return List<Election> elections
	 */
	public List<Election> findAllElections() {
		connDao.RetriveConnection();
		elections= connDao.getElectionList(conn);
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
		
		connDao.insertElection(conn, election, elections);
		elections.add(election);
	}

	/**
	 * updateElection() - Updates an existing election.
	 * @param election
	 */
	public void updateElection(Election election) {
		connDao.updateElection(conn, election, elections);
	}

	/**
	 * deleteElectionByID() - Deletes an election from the database matching the electionID parameter.
	 * @param electionID
	 */
	public void deleteElectionById(int electionID) {
		connDao.deleteElection(conn, electionID, elections);
	}

	/**
	 * associateVoter() - Adds a userID and associated electionID to the vote authorization database table.
	 * @param electionID
	 * @param id
	 */
	public void associateVoter(int electionID, String id) {	
		connDao.insertVoteAuth(conn, electionID, id);
	}

	/**
	 * associateCandidate() - Adds an userID and associated electionID to the candidate database table.
	 * @param electionID
	 * @param id
	 */
	public void associateCandidate(int electionID, String id) {
		connDao.insertElectionCandidate(conn, electionID, id);
	}
	
	

}
