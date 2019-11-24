/*---------------------------------------------------------------------
|  Class ElectionHelperDao
|
|  Purpose: Election Database Queries
|
|  Methods: tallyCands, tallyVotes, calculateLead
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
 * ElectionHelperDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class ElectionHelperDao {
	ConnectionDao connectionDao = new ConnectionDao();
	
	/**
	 * tallyCands() - Candidate by ID and name
	 * @param electionID
	 * @return HashMap<String,String>
	 */
	public HashMap<String,String> tallyCands(int electionID){
	    //Display Votes in a Hash Map
	    HashMap<String,String> map = 
                new HashMap<String,String>(); 
	    String can = "";
	    String name = "";
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT electionCandidate.canID, user.first_name, user.last_name FROM electionCandidate " + 
		"INNER JOIN user ON user.id = electionCandidate.canID WHERE electionID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		 
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
		    can = rs.getString(1);
		    name = rs.getString(2) + " " + rs.getString(3);
		    map.put(name, can); 
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return map;	
	}
	
	/**
	 * tallyVotes() - Candidate by Votes
	 * @param electionID
	 * @return HashMap<String, Integer>
	 */
	public HashMap<String, Integer> tallyVotes(int electionID){
	    //Display Votes in a Hash Map
	    HashMap<String,Integer> map = 
                new HashMap<String, Integer>(); 
	    String can = "";
	    String name = "";
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT * FROM ballot WHERE electionID=? AND canID<>?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		stmt.setString(2,"Abstain");
		 
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
		    can = rs.getString(4);
		    name = rs.getString(5) + " " + rs.getString(6);
		    //If Candidate exists increment vote count
		    //Otherwise add new entry
		    if(map.keySet().contains(name)){
		        map.put(name, map.get(name) + 1); 
		    }else{
		        map.put(name, 1);
		    }
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return map;	
	}
	
	/**
	 * calculateLead() - Current Election Lead Candidate(s)
	 * @param electionID
	 * @return ArrayList<String>
	 */
	public ArrayList<String> calculateLead(int electionID){
	    //Return Array in case of Tie
	    ArrayList<String> winners = new ArrayList<String>();
	    //Returned List of Candidate Counts
	    HashMap<String,Integer> candidates = 
                new HashMap<String, Integer>(); 
	    candidates = tallyVotes(electionID);
		
	    //Loop through HashMap to Calculate Lead
	    int leadNum = 0;
	    String winner = "";
	    for(HashMap.Entry<String,Integer> entry : candidates.entrySet())
	    {
                String key = entry.getKey();
		Integer val = entry.getValue();
		//If new largest number of votes found
		//Clear current list of winners and start new list
		if(val > leadNum)
		{
		    winners.clear();
		    leadNum = val;
		    winner = key;
		    winners.add(winner);
		}else if(val == leadNum){
		    //If number of total votes match current lead
		    //Add to winner ArrayList
		    winners.add(winner);
		}
	    }
	    return winners;
	}
	
	/**
	 * tallyType() - Resturn list of users who abstained or wrote in for given election
	 * Can also returns users who voted for given candidate
	 * @param electionID, type
	 * @return ArrayList<User>
	 */
	public ArrayList<User> tallyType(int electionID, String type){
	    ArrayList<User> users = new ArrayList<User>();
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT * FROM ballot WHERE electionID=? AND canID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		stmt.setString(2,type);
		 
		ResultSet rs=stmt.executeQuery();
		UserConnectionDao userCon = new UserConnectionDao();
		User user = new User();
		//Loop through Users Returned
		while(rs.next()) {
			//Gather user data by userID
			user = userCon.getUserById(rs.getString(2));
			//Add user object to list to be returned
			users.add(user);
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return users;	
	}
	
}
