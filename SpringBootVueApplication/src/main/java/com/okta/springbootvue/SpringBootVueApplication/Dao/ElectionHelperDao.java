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

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * ElectionHelperDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class ElectionHelperDao {
	src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao connectionDao = new src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao();
	src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao electionConnectionDao = new src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao();
	
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
		src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao userCon = new src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao();
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


	/**
	 * calculateClosed() - Calculates if an election has elapsed it's closing date and time. Sets an election to 'closed'
	 * if current date and time are past close date and time.
	 * @param electionID
	 * @throws Exception
	 */
	public void calculateClosed(int electionID) {
		Boolean closed = false;
		String closeDate = "";
		String closeTime = "";
		Election election = new Election();
		List<Election> electionList = new ArrayList<>();

		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM election WHERE electionID=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			//stmt.setInt(1,electionID);
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

		//Assign closeDate the election's closing date
		closeDate = election.getClose_date();

		//Assign closeTime the election's closing time
		closeTime = election.getClose_time();

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
