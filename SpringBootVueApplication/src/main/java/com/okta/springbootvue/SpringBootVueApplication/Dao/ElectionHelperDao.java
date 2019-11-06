/*---------------------------------------------------------------------
|  Class ElectionConnectionDao
|
|  Purpose: Election Database Queries
|
|  Methods: getElectionList, getElectionByID, insertElection, updateElection,
|           deleteElection, insertVoteAuth, insertElectionCandidate,
|           removeElectionCandidate, getCandidatesByElection
|
|  Version: Sprint 2
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
 * ElectionHelperDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class ElectionHelperDao {
	ConnectionDao connectionDao = new ConnectionDao();
	
	/**
	 * tallyVotes() - 
	 * @param 
	 * @return 
	 */
	public Map<String, Integer> tallyVotes(int electionID){
	    //Display Votes in a Hash Map
	    Map<String,Integer> map = 
                new HashMap<String, Integer>(); 
	    String can = "";
	    String name = "";
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT * FROM ballot WHERE electionID=? AND canID<>?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		stmt.setInt(2,'Abstain');
		 
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
	 * tallyType() - Resturn list of users who abstained or wrote in for given election
	 * @param 
	 * @return 
	 */
	public ArrayList<User> tallyAbstains(int electionID, String type){
	    ArrayList<User> users = new ArrayList<User>();
		
	    try {
		Connection conn = connectionDao.RetrieveConnection();
		String sql = "SELECT * FROM ballot WHERE electionID=? AND canID=?"; 
		PreparedStatement stmt=conn.prepareStatement(sql); 
		stmt.setInt(1,electionID);
		stmt.setString(2,type);
		 
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			users.add(rs.getString(2));
		}	
		connectionDao.ReleaseConnection(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return users;	
	}
}
