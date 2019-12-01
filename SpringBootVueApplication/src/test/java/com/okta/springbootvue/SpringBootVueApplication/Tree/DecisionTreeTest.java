package com.okta.springbootvue.SpringBootVueApplication.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Node;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Ballot;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
public class DecisionTreeTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Tree.DecisionTree tree;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.TreeHelperDao treeHelper;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionHelperDao electionHelper;

    //New Election Object
    Election election = new Election();
    Election election2 = new Election();
    
    //New Candidate Object
    Candidate candidate = new Candidate();
    Candidate candidate2 = new Candidate();
    
    //New User Object
    User user = new User();
    User user2 = new User();
    
    //New Ballot Object
    Ballot ballot = new Ballot();
    Ballot ballot2 = new Ballot();

    //New Tree
    ArrayList<Node> nodeTree = new ArrayList<Node>();

    //Set Object Variable values before each test case
    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);

        election.setElectionID(1);
        
        election2.setElectionID(2);
        candidate.setCanID("test1");
        candidate.setElectionID(2);
        candidate.setCanID("test2");
        candidate2.setElectionID(2);
        
        user.setId("voter1");
        user2.setId("voter2");
        
        ballot.setBallotID(1);
        ballot2.setBallotID(2);
        ballot.setUserID("voter1");
        ballot2.setUserID("voter2");
        ballot.setElectionID(1);
        ballot2.setElectionID(1);
        ballot.setCanID("test1");
        ballot2.setCanID("test2");

        nodeTree = tree.getNodes();
    }

    @Test
    public void calculateChancesTest() {
    	//Election with no candidates
    	assertNotNull(tree.calculateChances(1));
    	
    	//Election with Candidates
    	assertNotNull(tree.calculateChances(2));
    }
    
    @Test
    public void traverseTreeTestOne() {
    	//Create Variables
    	int electionID = 1;
    	String canID = "test1";
    	int ballotTotal = 100, ballotLow = 50, ballotGender = 50, ballotRace = 50, ballotQuestion = 10;
    	
    	//First Call Returns
    	HashMap<String, Integer> majorities = new HashMap<String, Integer>();
    	majorities.put("Total", 500);
    	majorities.put("Gender", 500);
    	majorities.put("Race", 500);
    	
    	Mockito.when(treeHelper.getCandInfo(electionID, canID)).thenReturn(majorities);
    	Mockito.when(treeHelper.getCandQuestionInfo(electionID, canID)).thenReturn(100);
    	
    	String callOne = tree.traverseTree(electionID, canID, nodeTree, ballotTotal, ballotLow, ballotGender, ballotRace, ballotQuestion);
    	assertNotNull(callOne);
    	assertEquals(callOne, "Unlikely");
    	
    }
    
    @Test
    public void traverseTreeTestTwo() {
    	//Create Variables
    	int electionID = 1;
    	String canID = "test1";
    	int ballotTotal = 100, ballotLow = 50, ballotGender = 50, ballotRace = 50, ballotQuestion = 10;
    	
    	//Second Call Returns
    	HashMap<String, Integer> majorities2 = new HashMap<String, Integer>();
    	majorities2.put("Total", 0);
    	majorities2.put("Gender", 0);
    	majorities2.put("Race", 0);
    	
    	Mockito.when(treeHelper.getCandInfo(electionID, canID)).thenReturn(majorities2);
    	Mockito.when(treeHelper.getCandQuestionInfo(electionID, canID)).thenReturn(0);
    	
    	String callTwo = tree.traverseTree(electionID, canID, nodeTree, ballotTotal, ballotLow, ballotGender, ballotRace, ballotQuestion);
    	assertNotNull(callTwo);
    	assertEquals(callTwo, "Unlikely");
    	
    }
    
    @Test
    public void getNodesTest() {
    	//Get Tree
    	assertNotNull(tree.getNodes());

    }

}