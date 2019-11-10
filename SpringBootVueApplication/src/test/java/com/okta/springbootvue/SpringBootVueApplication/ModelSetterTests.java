/*---------------------------------------------------------------------
|  Class ModelSetterTests
|
|  Purpose: Test setting of Model class variables.
|
|  Methods: TestSetUser, TestSetElection, TestSetCandidate, TestSetQuestion,
|           TestSetPolicy, TestSetBallot
|
|  Version: Sprint 3
|
*-------------------------------------------------------------------*/
package com.okta.springbootvue.SpringBootVueApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.Assert.*;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.*;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.*;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.SpringBootVueApplication;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

/**
 * ModelSetterTests() - This class tests the setters for each of the Model object classes.
 */
public class ModelSetterTests {

    //Creation of Model class objects

    public User user = new User();
    public User user2 = new User();
    public UserServiceImpl userService = new UserServiceImpl();
    public Election election = new Election();
    public Election election2 = new Election();
    public ElectionServiceImpl electionService = new ElectionServiceImpl();
    public Candidate candidate = new Candidate();
    public Candidate candidate2 = new Candidate();
    public CandidateServiceImpl candidateService = new CandidateServiceImpl();
    public Question question = new Question();
    public Question question2 = new Question();
    public Policy policy = new Policy();
    public Policy policy2 = new Policy();
    public Ballot ballot = new Ballot();
    public Ballot ballot2 = new Ballot();

    /**
     * TestSetUser() - Tests the setting of User Model object variables. Sets variables and checks for equivalency.
     * @throws Exception
     */
    @Test
    public void TestSetUser() throws Exception {
        //Set values of variables for user and user2 User objects
        user.setId("test");
        user.setType("Voter");
        user.setAge(25);
        user.setEthnicity("European");
        user.setGender("F");
        user.setAddress("160 Temp Drive");
        user.setCity("Philadelphia");
        user.setState("PA");
        user.setZip("12345");
        user.setFirst_name("Han");
        user.setLast_name("Solo");
        user.setProfile_complete(0);
        user.setUser_name("sw1");
        user.setRace("White");

        user2.setId("test");
        user2.setType("Voter");
        user2.setAge(25);
        user2.setEthnicity("European");
        user2.setGender("F");
        user2.setAddress("160 Temp Drive");
        user2.setCity("Philadelphia");
        user2.setState("PA");
        user2.setZip("12345");
        user2.setFirst_name("Han");
        user2.setLast_name("Solo");
        user2.setProfile_complete(0);
        user2.setUser_name("sw1");
        user2.setRace("White");

        //Test that user is equivalent to user2
        assertTrue(user.equals(user2));

        //Test the value of each of the variables of the user User object.
        assertEquals("test", user.getId());
        assertEquals("Voter", user.getType());
        assertEquals(25, user.getAge());
        assertEquals("European", user.getEthnicity());
        assertEquals("F", user.getGender());
        assertEquals("160 Temp Drive", user.getAddress());
        assertEquals("Philadelphia", user.getCity());
        assertEquals("PA", user.getState());
        assertEquals("12345", user.getZip());
        assertEquals("Han", user.getFirst_name());
        assertEquals("Solo", user.getLast_name());
        assertEquals(0, user.getProfile_complete());
        assertEquals("sw1", user.getUser_name());
        assertEquals("White", user.getRace());
    }

    /**
     * TestSetElection() - Tests the setting of Election Model object variables. Sets variables and checks for equivalency.
     * @throws Exception
     */
    @Test
    public void TestSetElection() throws Exception {
        //Set values of variables for election and election2 User objects
        election.setElectionID(1);
        election.setTitle("Test");
        election.setClosed(1);
        election.setClose_date("10-20-2019");
        election.setClose_time("5");
        election.setNum_candidates(3);
        election.setNum_votes(1);
        election.setStart_date("9-29-2019");
        election.setStart_time("8");
        election.setDescription("Description");
        election.setElection_key("1234");

        election2.setElectionID(1);
        election2.setTitle("Test");
        election2.setClosed(1);
        election2.setClose_date("10-20-2019");
        election2.setClose_time("5");
        election2.setNum_candidates(3);
        election2.setNum_votes(1);
        election2.setStart_date("9-29-2019");
        election2.setStart_time("8");
        election2.setDescription("Description");
        election2.setElection_key("1234");

        //Test that election is equivalent to election2
        assertTrue(election.equals(election2));

        //Test the value of each of the variables of the election Election object.
        assertEquals(1, election.getElectionID());
        assertEquals("Test", election.getTitle());
        assertEquals(1, election.getClosed());
        assertEquals("10-20-2019", election.getClose_date());
        assertEquals("5", election.getClose_time());
        assertEquals(3, election.getNum_candidates());
        assertEquals(1, election.getNum_votes());
        assertEquals("9-29-2019", election.getStart_date());
        assertEquals("8", election.getStart_time());
        assertEquals("Description", election.getDescription());
        assertEquals("1234", election.getElection_key());
    }

    /**
     * TestSetCandidate() - Tests the setting of Candidate Model object variables. Sets variables and checks for equivalency.
     * @throws Exception
     */
    @Test
    public void TestSetCandidate() throws Exception {
        //Set values of variables for candidate and candidate2 User objects
        candidate.setCanID("test");
        candidate.setUserID("userTest");
        candidate.setFirst_name("First");
        candidate.setLast_name("Last");
        candidate.setEmail("email");
        candidate.setElectionID(1);
        candidate.setAbout("about");
        candidate.setEducation("education");
        candidate.setEmployment("employment");
        candidate.setExperience("experience");
        candidate.setContact("contact");

        candidate2.setCanID("test");
        candidate2.setUserID("userTest");
        candidate2.setFirst_name("First");
        candidate2.setLast_name("Last");
        candidate2.setEmail("email");
        candidate2.setElectionID(1);
        candidate2.setAbout("about");
        candidate2.setEducation("education");
        candidate2.setEmployment("employment");
        candidate2.setExperience("experience");
        candidate2.setContact("contact");

        //Test that candidate is equivalent to candidate2
        assertTrue(candidate.equals(candidate2));

        //Test the value of each of the variables of the candidate Candidate object.
        assertEquals("test", candidate.getCanID());
        assertEquals("userTest", candidate.getUserID());
        assertEquals("First", candidate.getFirst_name());
        assertEquals("Last", candidate.getLast_name());
        assertEquals("email", candidate.getEmail());
        assertEquals(1, candidate.getElectionID());
        assertEquals("about", candidate.getAbout());
        assertEquals("education", candidate.getEducation());
        assertEquals("employment", candidate.getEmployment());
        assertEquals("experience", candidate.getExperience());
        assertEquals("contact", candidate.getContact());
    }

    /**
     * TestSetQuestion() - Tests the setting of Question Model object variables. Sets variables and checks for equivalency.
     * @throws Exception
     */
    @Test
    public void TestSetQuestion() throws Exception {
        //Set values of variables for question and question2 User objects
        question.setQID(1234);
        question.setCanID("1234");
        question.setUserID("1234");
        question.setQuestion("test");
        question.setAnswer("test");

        question2.setQID(1234);
        question2.setCanID("1234");
        question2.setUserID("1234");
        question2.setQuestion("test");
        question2.setAnswer("test");

        //Test that candidate is equivalent to candidate2
        assertTrue(question.equals(question2));

        //Test the value of each of the variables of the question and question2 Question objects.
        assertEquals(1234,question.getQID());
        assertEquals("1234",question.getCanID());
        assertEquals("1234", question.getUserID());
        assertEquals("test", question.getQuestion());
        assertEquals("test", question.getAnswer());

        assertEquals(1234,question2.getQID());
        assertEquals("1234",question2.getCanID());
        assertEquals("1234", question2.getUserID());
        assertEquals("test", question2.getQuestion());
        assertEquals("test", question2.getAnswer());
    }

    /**
     * TestSetPolicy() - Tests the setting of Policy Model object variables. Sets variables and checks for equivalency.
     * @throws Exception
     */
    @Test
    public void TestSetPolicy() throws Exception {
        //Set values of variables for policy and policy2 User objects
        policy.setElectionID(1234);
        policy.setType("test");
        policy.setFrequency(1);
        policy.setNum_votes(1);
        policy.setWrite_in(0);
        policy.setAbstain(0);

        policy2.setElectionID(1234);
        policy2.setType("test");
        policy2.setFrequency(1);
        policy2.setNum_votes(1);
        policy2.setWrite_in(0);
        policy2.setAbstain(0);

        //Test that policy is equivalent to policy2
        assertTrue(policy.equals(policy2));

        //Test the value of each of the variables of the policy and policy2 Policy objects.
        assertEquals(1234, policy.getElectionID());
        assertEquals("test", policy.getType());
        assertEquals(1, policy.getFrequency());
        assertEquals(1, policy.getNum_votes());
        assertEquals(0, policy.getWrite_in());
        assertEquals(0, policy.getAbstain());


        assertEquals(1234, policy2.getElectionID());
        assertEquals("test", policy2.getType());
        assertEquals(1, policy2.getFrequency());
        assertEquals(1, policy2.getNum_votes());
        assertEquals(0, policy2.getWrite_in());
        assertEquals(0, policy2.getAbstain());

    }

    /**
     * TestSetBallot() - Tests the setting of Ballot Model object variables. Sets variables and checks for equivalency.
     * @throws Exception
     */
    public void TestSetBallot() throws Exception {
        //Set values of variables for ballot and ballot2 User objects
        ballot.setBallotID(1);
        ballot.setUserID("test");
        ballot.setElectionID(1234);
        ballot.setCanID("test");
        ballot.setFirst_name("test");
        ballot.setLast_name("test");

        ballot2.setBallotID(1);
        ballot2.setUserID("test");
        ballot2.setElectionID(1234);
        ballot2.setCanID("test");
        ballot2.setFirst_name("test");
        ballot2.setLast_name("test");

        //Test that ballot is equivalent to ballot2
        assertTrue(ballot.equals(ballot2));

        //Test the value of each of the variables of the ballot and ballot2 Ballot objects.
        assertEquals(1, ballot.getBallotID());
        assertEquals("test", ballot.getUserID());
        assertEquals(1234, ballot.getElectionID());
        assertEquals("test", ballot.getCanID());
        assertEquals("test", ballot.getFirst_name());
        assertEquals("test", ballot.getLast_name());

        assertEquals(1, ballot2.getBallotID());
        assertEquals("test", ballot2.getUserID());
        assertEquals(1234, ballot2.getElectionID());
        assertEquals("test", ballot2.getCanID());
        assertEquals("test", ballot2.getFirst_name());
        assertEquals("test", ballot2.getLast_name());

    }

}