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

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;

/**
 * ElectionConnectionDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class ElectionConnectionDao {
	ConnectionDao connectionDao = new ConnectionDao();
	
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
			election.setAdmin1(rs.getInt(4));
			election.setAdmin2(rs.getInt(5));
			election.setAdmin3(rs.getInt(6));
			election.setAdmin4(rs.getInt(7));
			election.setAdmin5(rs.getInt(8));
			election.setAdmin6(rs.getInt(9));
			election.setChoice1(rs.getString(10));
			election.setChoice2(rs.getString(11));
			election.setChoice3(rs.getString(12));
			election.setChoice4(rs.getString(13));
			election.setChoice5(rs.getString(14));
			election.setClose_date(rs.getString(15));
			election.setClose_time(rs.getString(16));
			election.setNum_candidates(rs.getInt(17));
			election.setNum_votes(rs.getInt(18));
			election.setStart_date(rs.getString(19));
			election.setStart_time(rs.getString(20));
			election.setDescription(rs.getString(21));
			
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
				election.setAdmin1(rs.getInt(4));
				election.setAdmin2(rs.getInt(5));
				election.setAdmin3(rs.getInt(6));
				election.setAdmin4(rs.getInt(7));
				election.setAdmin5(rs.getInt(8));
				election.setAdmin6(rs.getInt(9));
				election.setChoice1(rs.getString(10));
				election.setChoice2(rs.getString(11));
				election.setChoice3(rs.getString(12));
				election.setChoice4(rs.getString(13));
				election.setChoice5(rs.getString(14));
				election.setClose_date(rs.getString(15));
				election.setClose_time(rs.getString(16));
				election.setNum_candidates(rs.getInt(17));
				election.setNum_votes(rs.getInt(18));
				election.setStart_date(rs.getString(19));
				election.setStart_time(rs.getString(20));
				election.setDescription(rs.getString(21));
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
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "INSERT INTO election (electionID, title, closed, admin1, admin2, admin3, admin4, admin5, admin6, choice1, choice2, " +
				"choice3, choice4, choice5, close_date, close_time, num_candidates, num_votes, start_date, start_time, description) " + 
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,election.getElectionID());
		stmt.setString(2,election.getTitle());
		stmt.setInt(3,election.getClosed());
		stmt.setInt(4,election.getAdmin1());
		stmt.setInt(5,election.getAdmin2());
		stmt.setInt(6,election.getAdmin3());
		stmt.setInt(7,election.getAdmin4());
		stmt.setInt(8,election.getAdmin5());
		stmt.setInt(9,election.getAdmin6());
		stmt.setString(10,election.getChoice1());
		stmt.setString(11,election.getChoice2());
		stmt.setString(12,election.getChoice3());
		stmt.setString(13,election.getChoice4());
		stmt.setString(14,election.getChoice5());
		stmt.setString(15,election.getClose_date());
		stmt.setString(16,election.getClose_time());
		stmt.setInt(17,election.getNum_candidates());
		stmt.setInt(18,election.getNum_votes());
		stmt.setString(19,election.getStart_date());
		stmt.setString(20,election.getStart_time());
		stmt.setString(21,election.getDescription());
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
		String sql = "UPDATE election SET electionID=?, title=?, closed=?, admin1=?, admin2=?, admin3=?, admin4=?, admin5=?, admin5=?, choice1=?, choice2=?, " +
				"choice1=?, choice4=?, choice5=?, close_date=?, close_time=?, num_candidates=?, num_votes=?, start_date=?, start_time=?, description=? WHERE electionID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setInt(1,election.getElectionID());
		stmt.setString(2,election.getTitle());
		stmt.setInt(3,election.getClosed());
		stmt.setInt(4,election.getAdmin1());
		stmt.setInt(5,election.getAdmin2());
		stmt.setInt(6,election.getAdmin3());
		stmt.setInt(7,election.getAdmin4());
		stmt.setInt(8,election.getAdmin5());
		stmt.setInt(9,election.getAdmin6());
		stmt.setString(10,election.getChoice1());
		stmt.setString(11,election.getChoice2());
		stmt.setString(12,election.getChoice3());
		stmt.setString(13,election.getChoice4());
		stmt.setString(14,election.getChoice5());
		stmt.setString(15,election.getClose_date());
		stmt.setString(16,election.getClose_time());
		stmt.setInt(17,election.getNum_candidates());
		stmt.setInt(18,election.getNum_votes());
		stmt.setString(19,election.getStart_date());
		stmt.setString(20,election.getStart_time());
		stmt.setString(21,election.getDescription());
		stmt.setInt(22,election.getElectionID());
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
	 * getCandidatesByElection() - Performs select MySQL statement to retrieve single candidate from candidate table.
	 * @param conn
	 * @return Candidate
	 */
	public List<Candidate> getCandidatesByElection(int electionID){
		List<Candidate> candidateList = new ArrayList<>();
		
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM candidate WHERE electionID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,electionID);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				Candidate candidate = new Candidate();
				candidate.setCanID(rs.getString(1));
				candidate.setUserID(rs.getString(2));
				candidate.setFirst_name(rs.getString(3));
				candidate.setLast_name(rs.getString(4));
				candidate.setEmail(rs.getString(5));
				candidate.setElectionID(rs.getInt(6));
				candidate.setAbout(rs.getString(7));
				candidate.setEducation(rs.getString(8));
				candidate.setEmployment(rs.getString(9));
				candidate.setExperience(rs.getString(10));
				candidate.setContact(rs.getString(11));
				candidateList.add(candidate);
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return candidateList;
	}
}

