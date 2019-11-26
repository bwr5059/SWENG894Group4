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
	
	/**
	 * calculateClosed() - Calculates if an election has elapsed it's closing date and time. Sets an election to 'closed'
	 * if current date and time are past close date and time.
	 * @param closeDate, closeTime
	 * @throws Exception
	 */
	public void calculateClosed(String closeDate, String closeTime) {
		Boolean closed = false;

		//Formatters for date and time
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

		Date formattedCloseDate;
		Date formattedCloseTime;
		try {
			//Parse election close date to adhere to date format
			formattedCloseDate=dateFormatter.parse(closeDate);

			//Parse election close time to adhere to the time format
			formattedCloseTime=timeFormatter.parse(closeTime);

			//Get the current date
			LocalDate nowDate = LocalDate.now();

			//Get today's date as a Date
			Date currentDate = Date.from(nowDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

			//Get the current time
			//LocalTime nowTime = LocalTime.now();

			//Get the current time in an instant
			Instant instant = Instant.now();

			// get overall time
			LocalTime time = instant.atZone(ZoneOffset.UTC).toLocalTime();
			// get hour
			int hour = instant.atZone(ZoneOffset.UTC).getHour();
			// get minute
			int minute = instant.atZone(ZoneOffset.UTC).getMinute();
			// get second
			int second = instant.atZone(ZoneOffset.UTC).getSecond();

			String currentTime = hour + ":" + minute + ":" + second;

			Date formattedCurrentTime=timeFormatter.parse(currentTime);

			//If past election close date, close election. If on election close date and after close time, close election
			if (currentDate.after(formattedCloseDate)) {
				election.setClosed(1);
				electionConnectionDao.updateElection(election,electionList);
			} else if(currentDate.equals(formattedCloseDate) && formattedCurrentTime.after(formattedCloseTime)) {
				election.setClosed(1);
				electionConnectionDao.updateElection(election,electionList);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
}
