/*---------------------------------------------------------------------
|  Class ElectionHelperDao
|
|  Purpose: Election Database Queries
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
	 * calculateLead() - 
	 * @param 
	 * @return 
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
	 * @param 
	 * @return 
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
	
	/**
	 * getDemographics() - Returns HashMap of User Demographics
	 * @param 
	 * @return 
	 */
	public HashMap<String, Integer> getDemographics(ArrayList<User> users){
	    HashMap<String, Integer> demo = 
                new HashMap<String, Integer>(); 
	    int total = users.size();
	
	    //Demographic Counts
	    //Gender
            int male = 0, female = 0, notDisclosed = 0;
	    //Race
	    int nativeA = 0, asian = 0, black = 0, nativeH = 0, white = 0;
	    //Ethnicity
	    int hispanic = 0, notHispanic = 0;
	    User curUser = new User();
	    int i = 0;
            //Loop through ArrayList of Users
	    for(User user : users){
		  curUser = users.get(i);
		  i++;
		  //Gender
		  switch(curUser.getGender()){
			  case "Male":
				  male++;
			  case "Female":
				  female++;
			  default:
				  notDisclosed++;
		  }
	          
		  //Race
		    switch(curUser.getRace()){
			    case "American Indian or Alaska Native":
				    nativeA++;
			    case "Asian":
				    asian++;
			    case "Black or African American":
				    black++;
			    case "Native Hawaiin or Other Pacific Islander":
				    nativeH++;
			    case "White":
				    white++;
			    default:
				    System.out.println("No Race");
		    }
		  //Ethnicity
		    switch(curUser.getEthnicity()){
			    case "Hispanic or Latino or Spanish Origin":
				    hispanic++;
			    case "Not Hispanic or Latino or Spanish Origin":
				    notHispanic++;
			    default:
				    System.out.println("No Ethnicity");
		    }
	    }
	    //Calculate Results
	    if(total>0){
		//Gender
	        demo.put("Male", (male/total));
	        demo.put("Female", (female/total));
	        demo.put("NA", (notDisclosed/total));
		//Race
		demo.put("NativeAmerican", (nativeA/total));
	        demo.put("Asian", (asian/total));
	        demo.put("Black", (black/total));
		demo.put("NativeHawaiian", (nativeH/total));
	        demo.put("White", (white/total));
		//Ethnicity
		demo.put("Hispanic", (hispanic/total));
	        demo.put("NotHispanic", (notHispanic/total));
	    }	
		
	    return demo;	
	}
}
