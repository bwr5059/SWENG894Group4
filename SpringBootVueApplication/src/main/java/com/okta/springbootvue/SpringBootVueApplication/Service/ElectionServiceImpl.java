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

@Service("electionService")
public class ElectionServiceImpl implements ElectionService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Election> elections;
	
	ElectionConnectionDao connDao = new ElectionConnectionDao();
	Connection conn = null;
	
	static{
		//users = populateDummyUsers();
	}
	
	public void getConnection() {
		conn = connDao.RetriveConnection();
		elections= connDao.getElectionList(conn);
	}

	//Select All Rows from User Table
	public List<Election> findAllElections() {
		connDao.RetriveConnection();
		elections= connDao.getElectionList(conn);
		return elections;
	}
	
	//Find single user by id
	public Election findById(int electionID) {
		elections = findAllElections();
		for(Election election : elections){
			if(election.getElectionID() == electionID){
				return election;
			}
		}
		return null;
	}
	
	public void addElection(Election election) {
		elections = findAllElections();
		
		connDao.insertElection(conn, election, elections);
		elections.add(election);
	}
	
	public void updateElection(Election election) {
		connDao.updateElection(conn, election, elections);
	}
	
	public void deleteElectionById(int electionID) {
		connDao.deleteElection(conn, electionID, elections);
	}
	
	public void associateVoter(int electionID, String id) {	
		connDao.insertVoteAuth(conn, electionID, id);
	}
	
	public void associateCandidate(String id, String electionID) {
		
	}
	
	

}
