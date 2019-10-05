package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

public class CandidateConnectionDao {
	ConnectionDao connectionDao = new ConnectionDao();
	
	/**
	 * getCandidateList() - Performs select MySQL statement to retrieve all candidates from candidate table.
	 * @param conn
	 * @return List<User>
	 */
	public List<Candidate> getCandidateList(){
		List<Candidate> candidateList = new ArrayList<>();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			
			Statement stmt=conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from candidate");  
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
			System.out.println("list is: "+candidateList.size());
			}catch(Exception e) {
				e.printStackTrace();
			}
		return candidateList;
	}
	
	/**
	 * getCandidateByID() - Performs select MySQL statement to retrieve single candidate from candidate table.
	 * @param conn
	 * @return Candidate
	 */
	public Candidate getCandidateById(String canID){
		Candidate candidate = new Candidate();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM candidate WHERE canID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setString(1,canID);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
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
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return candidate;
	}
	
	/**
	 * getCandidateByName() - Performs select MySQL statement to retrieve single candidate from candidate table.
	 * @param conn
	 * @return Candidate
	 */
	public Candidate getCandidateByName(String name){
		Candidate candidate = new Candidate();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM candidate WHERE last_name=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setString(1,name);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
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
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return candidate;
	}
	
	public void insertCandidate(Candidate candidate){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "INSERT INTO vision_database.candidate (canID, userID, first_name, last_name, email, electionID, about, education, employment, experience, contact) " +
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,candidate.getCanID());
		stmt.setString(2,candidate.getUserID());
		stmt.setString(3,candidate.getFirst_name());
		stmt.setString(4,candidate.getLast_name());
		stmt.setString(5,candidate.getEmail());
		stmt.setInt(6,candidate.getElectionID());
		stmt.setString(7,candidate.getAbout());
		stmt.setString(8,candidate.getEducation());
		stmt.setString(9,candidate.getEmployment());
		stmt.setString(10,candidate.getExperience());
		stmt.setString(11,candidate.getContact());
		stmt.executeUpdate();  
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * updateCandidate() - Updates a candidate in the candidate database table with received values using MySQL statement.
	 * @param conn
	 * @param candidate
	 * @param candidateList
	 * @return List<Candidate>
	 */
	public List<Candidate> updateCandidate(Candidate candidate, List<Candidate> candidateList){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "UPDATE candidate SET canID=?, userID=?, first_name=?, last_name=?, email=?, electionID=?, about=?, education=?, employment=?, experience=?, contact=? " +
				"WHERE canID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,candidate.getCanID());
		stmt.setString(2,candidate.getUserID());
		stmt.setString(3,candidate.getFirst_name());
		stmt.setString(4,candidate.getLast_name());
		stmt.setString(5,candidate.getEmail());
		stmt.setInt(6,candidate.getElectionID());
		stmt.setString(7,candidate.getAbout());
		stmt.setString(8,candidate.getEducation());
		stmt.setString(9,candidate.getEmployment());
		stmt.setString(10,candidate.getExperience());
		stmt.setString(11,candidate.getContact());
		stmt.setString(12,candidate.getCanID());
		stmt.executeUpdate(); 
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return candidateList;
	}

}