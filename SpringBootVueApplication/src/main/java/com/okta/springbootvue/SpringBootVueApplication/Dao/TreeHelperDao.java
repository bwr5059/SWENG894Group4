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
	public HashMap<String, Integer> getMajorities(int electionID){
	    //Display Votes in a Hash Map
	    HashMap<String,Integer> majorities = 
                new HashMap<String, Integer>(); 
	    int genCount = 0, raceCount = 0;
	    String genKey = "", raceKey = "";
		
	    //HashMap of Potential Genders and Races
	    HashMap<String,Integer> genCounts = 
                new HashMap<String, Integer>(); 
	    counts.put("Male",0);
	    counts.put("Female",0);
	    counts.put("Not Disclosed",0);
	    HashMap<String,Integer> raceCounts = 
                new HashMap<String, Integer>(); 
	    counts.put("American Indian or Alaska Native",0);
	    counts.put("Asian",0);
	    counts.put("Black or African American",0);
	    counts.put("Native Hawaiin or Other Pacific Islander",0);
	    counts.put("White",0);
	    counts.put("None",0);
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT gender, race FROM user INNER JOIN voteAuthorization ON " +
			"id = userID WHERE electionID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		 
		ResultSet rs=stmt.executeQuery();
		//Count Voter Genders
		while(rs.next()) {
		    switch(rs.getString(1)){
			  case "Male":
				  genCounts.put("Male", genCounts.get(key) + 1);
			  case "Female":
				  genCounts.put("Female", genCounts.get(key) + 1);;
			  default:
				  genCounts.put("Not Disclosed", genCounts.get(key) + 1);;
		    }
		  
	            //Count Voter Races
		    switch(rs.getString(2)){
			    case "American Indian or Alaska Native":
				    raceCounts.put("American Indian or Alaska Native", raceCounts.get(key) + 1);
			    case "Asian":
				    raceCounts.put("Asian", raceCounts.get(key) + 1);
			    case "Black or African American":
				    raceCounts.put("Black or African American", raceCounts.get(key) + 1);
			    case "Native Hawaiin or Other Pacific Islander":
				    raceCounts.put("Native Hawaiian or Other Pacific Islander", raceCounts.get(key) + 1);
			    case "White":
				    raceCounts.put("White", raceCounts.get(key) + 1);
			    default:
				    raceCounts.put("None", raceCounts.get(key) + 1);
		    }
		}	
		connectionDao.ReleaseConnection(conn);
		//Loop through counts to get Majority Gender and Race
		for(HashMap.Entry<String,Integer> entry : genCounts.entrySet())
            	     if(genCounts.Value>genCount){
		         genCounts = entry.getValue();
			 genKey = entry.getKey();
		     }
    		}
		for(HashMap.Entry<String,Integer> entry : racents.entrySet())
            	     if(genCounts.Value>genCount){
		         raceCounts = entry.getValue();
			 raceKey = entry.getKey();
		     }
    		}
	        majorities.put(genKey,genCounts);
	        majorities.put(raceKey,raceCounts);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return majorities;
	}
	
}
