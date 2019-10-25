/*---------------------------------------------------------------------
|  Class ElectionConnectionDao
|
|  Purpose: Election Database Queries
|
|  Methods: getElectionList, getElectionByID, insertElection, updateElection,
|           deleteElection, insertVoteAuth, insertElectionCandidate,
|           removeElectionCandidate, getCandidatesByElection
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.HashMap;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;

/**
 * ElectionConnectionDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class ElectionConnectionDao {
	ConnectionDao connectionDao = new ConnectionDao();
	
	/**
	 * getMaxID() - Gets current highest electionID
	 * @return int
	 */
	public int getMaxID(){
		int maxID = 0;
		try {
			Connection conn = connectionDao.RetrieveConnection();
			Statement stmt=conn.createStatement(); 
			ResultSet rs=stmt.executeQuery("SELECT MAX(electionID) FROM election"); 
			while(rs.next())  {
				maxID = rs.getInt(1);
			}
			connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return maxID;
		
	}
	
	/**
	 * getElectionList - Performs select MySQL statement to retrieve all elections from election table.
	 * @param conn
	 * @return List<Election>
	 */
	public List<Election> getElectionList(){
		List<Election> electionList = new ArrayList<>();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			
		Statement stmt=conn.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from election");  
		while(rs.next())  {
			Election election = new Election();
			election.setElectionID(rs.getInt(1));
			election.setTitle(rs.getString(2));
			election.setClosed(rs.getInt(3));
			election.setClose_date(rs.getString(4));
			election.setClose_time(rs.getString(5));
			election.setNum_candidates(rs.getInt(6));
			election.setNum_votes(rs.getInt(7));
			election.setStart_date(rs.getString(8));
			election.setStart_time(rs.getString(9));
			election.setDescription(rs.getString(10));
			election.setElection_key(rs.getString(11));
			
			electionList.add(election);
		}
		connectionDao.ReleaseConnection(conn);
		System.out.println("list is: "+electionList.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return electionList;

	}
	
	/**
	 * getElectionByID() - Performs select MySQL statement to retrieve single user from user table.
	 * @param conn
	 * @return User
	 */
	public Election getElectionById(int electionID){
		Election election = new Election();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM election WHERE electionID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,electionID);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				election.setElectionID(rs.getInt(1));
				election.setTitle(rs.getString(2));
				election.setClosed(rs.getInt(3));
				election.setClose_date(rs.getString(4));
				election.setClose_time(rs.getString(5));
				election.setNum_candidates(rs.getInt(6));
				election.setNum_votes(rs.getInt(7));
				election.setStart_date(rs.getString(8));
				election.setStart_time(rs.getString(9));
				election.setDescription(rs.getString(10));
				election.setElection_key(rs.getString(11));
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return election;
	}
	
	/**
	 * insertElection() - Inserts a new election row into the election database table using MySQL statement.
	 * @param conn
	 * @param election
	 * @param electionList
	 * @return List<Election>
	 */
	public List<Election> insertElection(Election election, List<Election> electionList){
		int newID = getMaxID() + 1;
		election.setElectionID(newID);
		
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "INSERT INTO election (electionID, title, closed, close_date, close_time, num_candidates, num_votes, start_date, start_time, description, election_key) " + 
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,election.getElectionID());
		stmt.setString(2,election.getTitle());
		stmt.setInt(3,election.getClosed());
		stmt.setString(4,election.getClose_date());
		stmt.setString(5,election.getClose_time());
		stmt.setInt(6,election.getNum_candidates());
		stmt.setInt(7,election.getNum_votes());
		stmt.setString(8,election.getStart_date());
		stmt.setString(9,election.getStart_time());
		stmt.setString(10,election.getDescription());
		stmt.setString(11,election.getElection_key());
		stmt.executeUpdate();  
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return electionList;
		
	}
	
	/**
	 * updateElection() - Updates an election in the election database table with received values using MySQL statement.
	 * @param conn
	 * @param election
	 * @param electionList
	 * @return List<Election>
	 */
	public List<Election> updateElection(Election election, List<Election> electionList){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "UPDATE election SET electionID=?, title=?, closed=?, " +
				"close_date=?, close_time=?, num_candidates=?, num_votes=?, start_date=?, start_time=?, description=?, election_key=? WHERE electionID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,election.getElectionID());
		stmt.setString(2,election.getTitle());
		stmt.setInt(3,election.getClosed());
		stmt.setString(4,election.getClose_date());
		stmt.setString(5,election.getClose_time());
		stmt.setInt(6,election.getNum_candidates());
		stmt.setInt(7,election.getNum_votes());
		stmt.setString(8,election.getStart_date());
		stmt.setString(9,election.getStart_time());
		stmt.setString(10,election.getDescription());
		stmt.setString(11,election.getElection_key());
		stmt.setInt(12,election.getElectionID());
		stmt.executeUpdate(); 
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return electionList;
	}
	
	/**
	 * deleteElection() - Removes an election from the election database table that matches electionID parameter.
	 * @param conn
	 * @param electionID
	 * @param electionList
	 * @return List<Election>
	 */
	public List<Election> deleteElection(int electionID, List<Election> electionList){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "DELETE FROM election WHERE electionID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,electionID);
		stmt.executeUpdate();  
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return electionList;
		
	}
	
	/**
	 * insertVoteAuth - Receives an electionID and userID as parameters and insterts them into the voteAuthorization table.
	 * @param conn
	 * @param electionID
	 * @param id
	 */
	public void insertVoteAuth(int electionID, String id){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "INSERT INTO voteAuthorization (electionID, userID) VALUES (?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,electionID);
		stmt.setString(2,id);
		stmt.executeUpdate();  
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * removeVoteAuth() - 
	 * table.
	 * @param conn
	 * @param electionID
	 * @param id
	 */
	public void removeVoteAuth(int electionID, String userID){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "DELETE FROM voteAuthorization WHERE electionID=? AND userID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,electionID);
		stmt.setString(2,userID);
		stmt.executeUpdate();
		connectionDao.ReleaseConnection(conn); 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * getVoteAuth() - 
	 * @param 
	 * @return 
	 */
	public String getVoteAuth(int electionID, String userID){
		Election election = new Election();
		 String result = "Missing";
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM voteAuthorization WHERE electionID=? AND userID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,electionID);
			stmt.setString(2,userID);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				result = "Found";
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	
	/**
	 * insertElectionCandidate() - Receives an electionID and userID as parameters and inserts them into the electionCandidate
	 * table.
	 * @param conn
	 * @param electionID
	 * @param id
	 */
	public void insertElectionCandidate(int electionID, String id){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "INSERT INTO electionCandidate (electionID, canID) VALUES (?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,electionID);
		stmt.setString(2,id);
		stmt.executeUpdate();
		connectionDao.ReleaseConnection(conn); 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * removeElectionCandidate() - Receives an electionID and userID as parameters and inserts them into the electionCandidate
	 * table.
	 * @param conn
	 * @param electionID
	 * @param id
	 */
	public void removeElectionCandidate(int electionID, String id){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "DELETE FROM electionCandidate WHERE electionID=? AND canID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,electionID);
		stmt.setString(2,id);
		stmt.executeUpdate();
		connectionDao.ReleaseConnection(conn); 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * getElectionCandidate() - 
	 * @param 
	 * @return 
	 */
	public String getElectionCandidate(int electionID, String userID){
		Election election = new Election();
		 String result = "Missing";
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM electionCandidate WHERE electionID=? AND canID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,electionID);
			stmt.setString(2,userID);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				result = "Found";
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return result;
	}
	
	/**
	 * getCandidatesByElection() - Performs select MySQL statement to retrieve single candidate from candidate table.
	 * @param conn
	 * @return Candidate
	 */
	public List<HashMap<String, String>> getCandidatesByElection(int electionID){
		List<Candidate> candidateList = new ArrayList<>();
		List<HashMap<String, String>> listofMaps = new ArrayList<HashMap<String, String>>();
		
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT electionCandidate.canID, user.first_name, user.last_name " + 
				"FROM electionCandidate " +
				"INNER JOIN user ON electionCandidate.canID = user.id " + 
				"WHERE electionID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,electionID);
			 
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())  {
				HashMap<String, String> objMap = new HashMap<String, String>();
				objMap.put("canID",rs.getString(1));
				objMap.put("first_name",rs.getString(2));
				objMap.put("last_name",rs.getString(3));
				
				listofMaps.add(objMap);
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return listofMaps;
	}
	
	/**
	 * getPolicy() - Performs select MySQL statement to retrieve single user from electionPolicy table.
	 * @param 
	 * @return 
	 */
	public Policy getPolicy(int electionID){
		Policy policy = new Policy();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM policy WHERE electionID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,electionID);
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				policy.setElectionID(rs.getInt(1));
				policy.setType(rs.getString(2));
				policy.setFrequency(rs.getInt(3));
				policy.setNum_votes(rs.getInt(4));
				policy.setWrite_in(rs.getInt(5));
				policy.setAbstain(rs.getInt(6));
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return policy;
	}
	
	/**
	 * insertPolicy() - Inserts a new policy row into the electionPolicy database table using MySQL statement.
	 * @param 
	 * @param 
	 * @param 
	 * @return 
	 */
	public void insertPolicy(Policy policy){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "INSERT INTO policy (electionID, type, frequency, num_votes, write_in, abstain) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,policy.getElectionID());
		stmt.setString(2,policy.getType());
		stmt.setInt(3,policy.getFrequency());
		stmt.setInt(4,policy.getNum_votes());
		stmt.setInt(5,policy.getWrite_in());
		stmt.setInt(6,policy.getAbstain());

		stmt.executeUpdate();  
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * updatePolicy() - 
	 * @param 
	 * @param 
	 * @param 
	 * @return 
	 */
	public void updatePolicy(Policy policy){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "UPDATE policy SET electionID=?, type=?, frequency=?, num_votes=?, write_in=?, abstain=? WHERE electionID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,policy.getElectionID());
		stmt.setString(2,policy.getType());
		stmt.setInt(3,policy.getFrequency());
		stmt.setInt(4,policy.getNum_votes());
		stmt.setInt(5,policy.getWrite_in());
		stmt.setInt(6,policy.getAbstain());
		stmt.setInt(7,policy.getElectionID());

		stmt.executeUpdate(); 
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getVotesByVoter() - 
	 * @param 
	 * @return 
	 */
	public int getVotesByVoter(int electionID, String userID){
		Election election = new Election();
		 int result = 0;
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT COUNT(*) FROM ballot WHERE electionID=? AND userID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,electionID);
			stmt.setString(2,userID);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return result;
	}
}

