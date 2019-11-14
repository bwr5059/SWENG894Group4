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
	public String traverseTree(int electionID, String canID, ArrayList<Node> tree) {
		//Object to call functions to collect election
		//and candidate analytical data
		TreeHelperDao treeHelper = new TreeHelperDao();
		
		//Election Analytics
		//Total number of potential votes
		int ballotTotal = treeHelper.getTotalPotentialVotes(electionID);
		//Number of registered candidates
		int ballotLow = treeHelper.getTotalRegCands(electionID);
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
	public HashMap<String, Integer> calculateChances(int electionID, ArrayList<String> candidates) {
		//Query Tree Nodes
		//Assemble Decision Tree
		ArrayList<Node> tree = getNodes();
		
		//Percentage Results
		HashMap<String,Integer> results = 
                	new HashMap<String, Integer>();
		//Likely Candidates
		HashMap<String,Integer> likely = 
                	new HashMap<String, Integer>();
		//Potential Candidates
		HashMap<String,Integer> potential = 
                	new HashMap<String, Integer>();
		//Unlikely Candidates
		HashMap<String,Integer> unlikely = 
                	new HashMap<String, Integer>();
		
		//Election Info
		int totalCans = candidates.size();
		int totalWrites = 0;
		
		String type="";
		//Loop through Candidates
		for(String can : candidates){
		    if(!can.equals("Write")){
		        type =  traverseTree(electionID, can, tree);
		    	if(type.equals("Likely")){
		            likely.put(can,0);
		        }else if(type.equals("Potential")){
			    potential.put(can,0);
		        }else if(type.equals("Unlikely")){
	                    unlikely.put(can,0);
		        }
		    }else{
		        totalWrites++;
		    }
		}
	}
	

}
