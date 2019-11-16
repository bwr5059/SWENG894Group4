package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Tree;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Node;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionHelperDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.TreeHelperDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.HashMap;

public class DecisionTree {
	ConnectionDao connectionDao = new ConnectionDao();
	
	/**
	 * getElectionList - Performs select MySQL statement to retrieve all elections from election table.
	 * @param conn
	 * @return List<Election>
	 */
	public ArrayList<Node> getNodes(){
		ArrayList<Node> nodeList = new ArrayList<Node>();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			
		Statement stmt=conn.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from node");  
		while(rs.next())  {
			Node node = new Node();
			node.setType(rs.getString(1));
			node.setLeft(rs.getInt(2));
			node.setRight(rs.getInt(3));
			node.setIdNode(rs.getInt(4));
			
			nodeList.add(node);
		}
		connectionDao.ReleaseConnection(conn);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return nodeList;

	}
	
	
	/*
	 * *
	 */
	public String traverseTree(int electionID, String canID, ArrayList<Node> tree, int ballotTotal, int ballotLow) {
		//Object to call functions to collect election
		//and candidate analytical data
		TreeHelperDao treeHelper = new TreeHelperDao();
		
		//Election Analytics
		//Total number of potential votes sent through parameters
		//Number of registered candidates send through parameters
		//Smallest Number of Votes Needed to Win
		ballotLow = ((1/ballotLow)*ballotTotal)+1;
		//Majority of Votes
		ballotTotal = (ballotTotal/2)+1;
		//Number of potential votes from majority gender
		int ballotGender = treeHelper.getVoterMajority(electionID, 1);
		//Number of potential votes from majority race
		int ballotRace = treeHelper.getVoterMajority(electionID, 2);
		//Number of questions for candidates registered in election
		int ballotQuestion = treeHelper.getTotalQuestions(electionID);
		
		//Candidate Analytics
		HashMap<String,Integer> majorities = treeHelper.getCandInfo(electionID, canID);
		//Number of votes received so far
		int total = majorities.get("Total");
		//Number of votes from majority gender
		int gender = majorities.get("Gender");
		//Number of votes from majority race
		int race = majorities.get("Race");
		//Number of votes received so far
		int low = total;
		//Number of Questions Asked to Candidate
		int question= treeHelper.getCandQuestionInfo(electionID, canID);
		
		
		
		String result = "";
		int id = 0;
		String type = "";
		boolean go = true;
		while(go) {
			type = tree.get(id).getType();
			if(type.equals("total")) {
				if(total>=ballotTotal) {
					id = tree.get(id).getLeft();
				}else {
					id = tree.get(id).getRight();
				}
			}else if(type.equals("low")) {
				if(low>=ballotLow) {
					id = tree.get(id).getLeft();
				}else {
					id = tree.get(id).getRight();
				}
			}else if(type.equals("gender")) {
				if(gender>=ballotGender) {
					id = tree.get(id).getLeft();
				}else {
					id = tree.get(id).getRight();
				}
			}else if(type.equals("race")) {
				if(race>=ballotRace) {
					id = tree.get(id).getLeft();
				}else {
					id = tree.get(id).getRight();
				}
			}else if(type.equals("question")) {
				if(question>=ballotQuestion) {
					id = tree.get(id).getLeft();
				}else {
					id = tree.get(id).getRight();
				}
			}else {
				result = type;
				go = false;
			}
			
		}
		
		return result;
	}
	
	/*
	 * *
	 */
	public HashMap<String, Integer> calculateChances(int electionID) {
		//Objects to Call Helper Methods
		TreeHelperDao treeHelper = new TreeHelperDao();
		ElectionHelperDao electionHelper = new ElectionHelperDao();
		
		//Get Candidates with Votes
		HashMap<String, Integer> candidates = electionHelper.tallyVotes(electionID);
		
		//Check Ballot Submission Progress
		//Total number of potential votes
		int ballotTotal = treeHelper.getTotalPotentialVotes(electionID);
		//Total votes submitted to date
		int ballotToDate = treeHelper.getVotesToDate(electionID);
		float ballotProg = ballotToDate/ballotTotal;
		
		//If Election was Decided by Chance
		//this would be the prediction of 
		//each candidate
		//Number of Registered Candidates
		int ballotLow = treeHelper.getTotalRegCands(electionID);
		int startChance = (1/ballotLow)*100;//Consider write ins?
		
		//Smallest Number of Votes Needed to Win Election
		int smallTotal = startChance*ballotTotal;
		
		//Largest Number of Votes Needed to Win Election
		int largeTotal = (ballotTotal/2)+1;
		
		//Results
		HashMap<String, Integer>  results = 
                	new HashMap<String, Integer>();
		
		//If the number of votes submitted is less than total needed to win
		//All chances are roughly the same
		if(ballotProg < smallTotal){
			for(String can : candidates){
		    		if(!can.equals("Write")){
		        		results.put(can,startChance);
				}
			}
			//Only one "Write-in" Entry for Pie Chart
			results.put("Write",startChance);
		}else{
			//Query Tree Nodes
			//Assemble Decision Tree
			ArrayList<Node> tree = getNodes();
			String type="";
			int chance = 0;
			//How to get candidate num votes???
			String canID = "";
			int numVotes = 0;
			//Count the total chance Count
			int chanceCount = 0;
			int totalWrites = 0;
			
			//Loop through Candidates
			for(Map.Entry can : candidates.entrySet()){
				numVotes = can.getValue();
				canID = can.getKey();
		    		if(!canID.equals("Write")){
		        		type =  traverseTree(electionID, canID, tree, ballotTotal, ballotLow);
					//Weight each candidate chance
		    			if(type.equals("Likely")){
						chance = startChance * 2 * numVotes;
		        		}else if(type.equals("Potential")){
			    			chance = startChance * numVotes;
		        		}else if(type.equals("Unlikely")){
	                    			chance = startChance * (1/2) * numVotes;
		        		}
					results.put(canID,chance);
		    		}else{
		        		//Handle Write In Votes
		    			totalWrites = numVotes;
		    			chance = numVotes;
		    		}
				chanceCount = chanceCount + chance;
			}
			//Add final Write Entry
			results.put("Write",totalWrites);
			
			//Fix Weights to Equal 100
			//chance/chanceCount
			
		}
		return results;
	}
	
	

}
