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
	public HashMap<String, Float> calculateChances(int electionID) {
		//Objects to Call Helper Methods
		TreeHelperDao treeHelper = new TreeHelperDao();
		ElectionHelperDao electionHelper = new ElectionHelperDao();
		
		//Get Total Candidates
		HashMap<String, String> regCandidates = electionHelper.tallyCands(electionID);
		System.out.println("REGISTERED CANS: " + regCandidates);
		
		//Get Candidates with Votes
		HashMap<String, Integer> candidates = electionHelper.tallyVotes(electionID);
		System.out.println("CANS WITH VOTES: " + candidates);
		
		//Check Ballot Submission Progress
		//Total number of potential votes
		int ballotTotal = treeHelper.getTotalPotentialVotes(electionID) + 1;//+1 for Write-Ins
		//Total votes submitted to date
		int ballotToDate = treeHelper.getVotesToDate(electionID);
		System.out.println("TO DATE: " + ballotToDate);
		float ballotProg = 0;
		if(ballotTotal>0) {
			ballotProg = (float)ballotToDate/ballotTotal;
		}
		
		
		//If Election was Decided by Chance
		//this would be the prediction of 
		//each candidate
		//Number of Registered Candidates
		//int ballotLow = treeHelper.getTotalRegCands(electionID);
		int ballotLow = regCandidates.size();
		System.out.println("NUM REG CANDS: " + ballotLow);
		float startChance = (1/((float)ballotLow+1));//Plus 1 for Write-Ins
		System.out.println("START CHANCE: " + startChance);
		
		//Smallest Number of Votes Needed to Win Election
		float smallTotal = startChance*ballotTotal;
		System.out.println("SMALL TOTAL: " + smallTotal);
		
		//Largest Number of Votes Needed to Win Election
		float largeTotal = (ballotTotal/2)+1;
		System.out.println("LARGE TOTAL: " + largeTotal);
		
		//Results
		HashMap<String, Float>  results = 
                	new HashMap<String, Float>();
		String canName = "";
		String canID = "";
		
		//If the number of votes submitted is less than total needed to win
		//All chances are roughly the same
		System.out.println("BALLOT PROG: " + ballotProg);
		System.out.println("BALLOT TOTAL: " + ballotTotal);
		System.out.println("SMALL TOTAL: " + smallTotal);
		
		if((ballotProg*ballotTotal) <= smallTotal){
			for(HashMap.Entry<String,String> entry : regCandidates.entrySet()){
				canName = entry.getKey();
				System.out.println("CAN: " + canName);
		        results.put(canName,startChance);
			}
			//Only one "Write-in" Entry for Pie Chart
			results.put("Write",startChance);
		}else{
			//Query Tree Nodes
			//Assemble Decision Tree
			ArrayList<Node> tree = getNodes();
			String type="";
			float chance = 0;
			float numVotes = 0;
			float totalVotesCast = 0;
			//Count the total chance Count
			float chanceCount = 0;
			float totalWrites = 0;
			
			//Loop through Registered Candidates
			for(HashMap.Entry<String,String> entry : regCandidates.entrySet()){
				canID = entry.getValue();
				canName = entry.getKey();
		    		
				//Check if Candidate has any votes
				if(candidates.get(canName) != null){
					//Get Number of Votes Candidate Received
					numVotes = (float)candidates.get(canName);
					//Keep tally of votes to registered candidates
					totalVotesCast = totalVotesCast + numVotes;
					
					//Traverse Decision Tree to Predict Chance
		        	type =  traverseTree(electionID, canID, tree, ballotTotal, ballotLow);
		        	
					//Weight each candidate chance
		    		if(type.equals("Likely")){
						chance = startChance * 2 * numVotes;
						System.out.println(canName + ": Likely");
		        	}else if(type.equals("Potential")){
			    		chance = startChance * numVotes;
			    		System.out.println(canName + ": Potential");
		        	}else if(type.equals("Unlikely")){
	                	chance = startChance * (1/2) * numVotes;
	                	System.out.println(canName + ": Unlikely");
		        	}
		    		
		    		//Add Weighted Chance to results
					results.put(canName,chance);
		    	}else{
		    			//Candidate has not received any votes
		    			results.put(canName,(float)0);
		    	}
				
				//Tally Total Weighted Votes
				chanceCount = chanceCount + chance;
			}
			//All other votes go to Write-Ins
			results.put("Write",((float)ballotToDate-totalVotesCast));

			float result = 0;
			//Fix Weights to Equal 100
			for(HashMap.Entry<String,Float> entry : results.entrySet()){
				numVotes = entry.getValue();
				canID = entry.getKey();
				result = numVotes/chanceCount;
				results.put(canID, result);
			}
			
			
		}
		return results;
	}
	
	

}
