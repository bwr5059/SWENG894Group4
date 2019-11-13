/*---------------------------------------------------------------------
|  Class TreeHelperDao
|
|  Purpose: Tree Database Queries
|
|  Methods: 
|
|  Version: Sprint 3
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
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;

/**
 * TreeHelperDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class TreeHelperDao {
	ConnectionDao connectionDao = new ConnectionDao();
	
	/**
	 * getTotalPotentialVotes() - 
	 * @param 
	 * @return 
	 */
	public int getTotalPotentialVotes(int electionID){
	    int total = 0;
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT count(userID) FROM voteAuthorization WHERE electionID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		 
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
		    total = rs.getInt(1);
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return total;	
	}
	
	/**
	 * getTotalRegCands() - 
	 * @param 
	 * @return 
	 */
	public int getTotalRegCands(int electionID){
	    int total = 0;
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT count(canID) FROM electionCandidate WHERE electionID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		 
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
		    total = rs.getInt(1);
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return total;	
	}
	
	/**
	 * getTotalQuestions() - 
	 * @param 
	 * @return 
	 */
	public int getTotalQuestions(int electionID){
	    int total = 0;
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT count(qID) FROM question INNER JOIN electionCandidate " +
			"ON question.canID = electionCandidate.canID " +
			"WHERE electionID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		 
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
		    total = rs.getInt(1);
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return total;	
	}
	
	/**
	 * getMajorities() - 
	 * @param 
	 * @return 
	 */
	public HashMap<String, Integer> getVoterMajority(int electionID, int val, HashMap<String, Integer> counts){
	    //Display Votes in a Hash Map
	    HashMap<String,Integer> majority = 
                new HashMap<String, Integer>(); 
	    int count = 0;
	    String key = "";
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT gender, race FROM user INNER JOIN voteAuthorization ON " +
			"id = userID WHERE electionID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		ResultSet rs=stmt.executeQuery();
		    
		while(rs.next()) {
		   //Loop through counts to get Requested Majority
		    for(HashMap.Entry<String,Integer> entry : counts.entrySet()) {
            	     	if(entry.getKey().equals(rs.getString(val)){
		             counts.put(entry.getKey(), entry.getValue()+1);
		        }
    		    }
		    
		}	
		connectionDao.ReleaseConnection(conn);
			   
		//Loop through counts to get Majority Gender and Race
		for(HashMap.Entry<String,Integer> entry : counts.entrySet()) {
            	     if(entry.getValue()>count){
		         count = entry.getValue();
			 key = entry.getKey();
		     }
    		}
		
	        //Prepare to return majority value and count
	        majority.put(key,count);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return majority;
	}

/**
	 * getCandInfo() - 
	 * @param 
	 * @return 
	 */
	public HashMap<String, Integer> getCandInfo(int electionID, String canID, String majGen, String majRace){
	    //Display Candidate Vote Tallies in HashMap
	    HashMap<String,Integer> tallies = 
                new HashMap<String, Integer>(); 
	    int total=0, gender=0, race=0;
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT gender, race FROM user INNER JOIN ballot ON " +
			"id = userID WHERE electionID=? AND canID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		stmt.setString(2,canID);
		 
		ResultSet rs=stmt.executeQuery();
		//Count Voter Genders
		while(rs.next()) {
		    total++;
		    //check gender
		    if(rs.getString(1).equals(majGen)){
			gender++;
		    }
		    //check race
		    if(rs.getString(2).equals(majRace)){
		        race++;
		    }
		}
		  
			
		connectionDao.ReleaseConnection(conn);
		tallies.put("Total",total);
		tallies.put("Gender",gender);
		tallies.put("Race",race);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return tallies;
	}

/**
	 * getCandQuestionInfo() - 
	 * @param 
	 * @return 
	 */
	public int getCandQuestionInfo(int electionID, String canID){
	    int total = 0;
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT count(qID) FROM question INNER JOIN electionCandidate " +
			"ON question.canID = electionCandidate.canID " +
			"WHERE electionID=? AND canID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		stmt.setString(2,canID);
		 
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
		    total++;
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return total;	
	}
	
}
