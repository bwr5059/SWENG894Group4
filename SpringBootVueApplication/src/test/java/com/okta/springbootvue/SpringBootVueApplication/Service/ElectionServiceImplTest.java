package com.okta.springbootvue.SpringBootVueApplication.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Ballot;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class ElectionServiceImplTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionServiceImpl electionService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao connDao;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserServiceImpl userService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao userConnectionDao;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.CandidateServiceImpl candidateService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.CandidateConnectionDao candidateConnectionDao;


    //New Election Object
    Election election = new Election();

    //New Policy Object
    Policy policy = new Policy();

    //New User object
    User user = new User();

    //New Candidate Object
    Candidate candidate = new Candidate();

    //New Ballot Object
    Ballot ballot = new Ballot();

    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);

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

        election.setElectionID(1);
        election.setTitle("test");
        election.setClosed(0);
        election.setClose_date("date");
        election.setClose_time("time");
        election.setNum_candidates(5);
        election.setNum_votes(1);
        election.setStart_date("start");
        election.setStart_time("start");
        election.setDescription("test");
        election.setElection_key("12345");

        policy.setElectionID(1);
        policy.setType("test");
        policy.setFrequency(1);
        policy.setNum_votes(1);
        policy.setWrite_in(0);
        policy.setAbstain(0);

        candidate.setCanID("test");
        candidate.setUserID("test");
        candidate.setFirst_name("test");
        candidate.setLast_name("test");
        candidate.setEmail("test");
        candidate.setElectionID(1);
        candidate.setAbout("test");
        candidate.setEducation("test");
        candidate.setEmployment("test");
        candidate.setExperience("test");
        candidate.setContact("test");

        ballot.setBallotID(1234);
        ballot.setUserID("test");
        ballot.setElectionID(1);
        ballot.setCanID("test");
        ballot.setFirst_name("test");
        ballot.setLast_name("test");

    }


    @Test
    public void findAllElections() {
        List<Election> electionList = new ArrayList<Election>();
        electionList.add(election);

        electionService.addElection(election);

        List<Election> allElections = electionService.findAllElections();

        when(connDao.getElectionList()).thenReturn(allElections);
    }

    @Test
    public void findElectionById() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);
    }

    @Test
    public void addElection() {
        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);
    }

    @Test
    public void updateElection() {
        electionService.addElection(election);

        election.setTitle("test2");
        election.setElection_key("1234567");

        electionService.updateElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

    }

    @Test
    public void deleteElectionById() {

        List<Election> electionList = new ArrayList<Election>();

        Election election2 = new Election();

        electionService.addElection(election);

        electionService.deleteElectionById(1);

        when(connDao.getElectionById(1)).thenReturn(election2);
    }

    @Test
    public void associateVoter() {
        electionService.addElection(election);

        userService.addUser(user,"Voter");

        when(userConnectionDao.getUserById("test")).thenReturn(user);

        electionService.associateVoter(1,"test");

        when(electionService.validateVoter(1,"test")).thenReturn("Found");

    }

    @Test
    public void withdrawVoter() {
        electionService.addElection(election);

        userService.addUser(user,"Voter");

        when(userConnectionDao.getUserById("test")).thenReturn(user);

        electionService.associateVoter(1,"test");

        when(electionService.validateVoter(1,"test")).thenReturn("Found");

        electionService.withdrawVoter(1,"test");

        when(electionService.validateVoter(1,"test")).thenReturn("Missing");

    }

    @Test
    public void validateVoter() {
        electionService.addElection(election);

        userService.addUser(user,"Voter");

        when(userConnectionDao.getUserById("test")).thenReturn(user);

        electionService.associateVoter(1,"test");

        when(electionService.validateVoter(1,"test")).thenReturn("Found");
    }

    @Test
    public void associateCandidate() {
        electionService.addElection(election);

        candidateService.addCandidate(candidate);

        when(candidateConnectionDao.getCandidateById("test")).thenReturn(candidate);

        electionService.associateCandidate(1,"test");

        when(electionService.validateCandidate(1,"test")).thenReturn("Found");
    }

    @Test
    public void withdrawCandidate() {
        electionService.addElection(election);

        candidateService.addCandidate(candidate);

        when(candidateConnectionDao.getCandidateById("test")).thenReturn(candidate);

        electionService.associateCandidate(1,"test");

        when(electionService.validateCandidate(1,"test")).thenReturn("Found");

        electionService.withdrawCandidate(1,"test");

        when(electionService.validateCandidate(1,"test")).thenReturn("Missing");
    }

    @Test
    public void validateCandidate() {
        electionService.addElection(election);

        candidateService.addCandidate(candidate);

        when(candidateConnectionDao.getCandidateById("test")).thenReturn(candidate);

        electionService.associateCandidate(1,"test");

        when(electionService.validateCandidate(1,"test")).thenReturn("Found");
    }

    @Test
    public void viewCandidates() {
    }

    @Test
    public void getPolicy() {
        electionService.createPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policy);
    }

    @Test
    public void createPolicy() {
        electionService.createPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policy);
    }

    @Test
    public void modifyPolicy() {
        electionService.createPolicy(policy);

        policy.setWrite_in(1);
        policy.setAbstain(1);

        electionService.modifyPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policy);
    }

    @Test
    public void getVotesByVoter() {

        //Add Election and User
        electionService.addElection(election);

        userService.addUser(user,"Voter");

        //Associate user as a voter on the added election
        electionService.associateVoter(1,"test");

        //Add a Candidate
        candidateService.addCandidate(candidate);

        //Associate candidate as a candidate on the added election
        electionService.associateCandidate(1,"test");

        //Cast a vote using the ballot
        userService.castVote("cast",ballot);

        electionService.getVotesByVoter(1,"test");

        when(electionService.getVotesByVoter(1,"test")).thenReturn(1);
    }
}