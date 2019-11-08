package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Tree;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Node;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionHelperDao;

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
	public String traverseTree(int total, int low, int gender, int race, int question, ArrayList<Node> tree) {
		//Temporary Dummy Data
		int ballotTotal = 100;
		int ballotLow = 26;
		int ballotGender = 75;
		int ballotRace = 60;
		int ballotQuestion = 20;
		
		
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
	

}
