package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Before;
import org.junit.Ignore;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.junit.Assert.assertEquals;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class ElectionControllerTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.ElectionController electionController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionService electionService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService userService;

    Election election = new Election();

    User user = new User();

    Policy policy = new Policy();

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
        election.setAdmin1(1);
        election.setAdmin2(2);
        election.setAdmin3(3);
        election.setAdmin4(4);
        election.setAdmin5(5);
        election.setAdmin6(6);
        election.setChoice1("1");
        election.setChoice2("2");
        election.setChoice3("3");
        election.setChoice4("4");
        election.setChoice5("5");
        election.setClose_date("date");
        election.setClose_time("time");
        election.setNum_candidates(5);
        election.setNum_votes(1);
        election.setStart_date("start");
        election.setStart_time("start");
        election.setDescription("test");
        election.setKey("12345");

        policy.setElectionID(1);
        policy.setType("test");
        policy.setFrequency(1);
        policy.setNum_votes(1);


    }

    @Test
    public void listAllElections() {

        List<Election> electionList1 = new ArrayList<Election>();
        electionList1.add(election);

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        when(electionService.findAllElections()).thenReturn(electionList1);
    }


    @Test
    public void getElection() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        Election election2 = electionService.findElectionById(1);

        assertEquals(1,election2.getElectionID());
        assertEquals("test",election2.getTitle());
        assertEquals(0,election2.getClosed());

    }

    @Test
    public void newElection() {

        electionService.addElection(election);

        verify(electionService,times(1)).addElection(election);

    }

    @Test
    public void modifyElection() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        election.setElectionID(2);
        election.setTitle("test2");
        election.setClosed(1);

        electionService.updateElection(election);

        verify(electionService,times(1)).updateElection(election);

    }

    @Test
    public void deleteElection() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        electionService.deleteElectionById(1);

        verify(electionService,times(1)).deleteElectionById(1);
    }

    @Test
    public void associateVoter() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        electionService.associateVoter(1,"test");

        verify(electionService,times(1)).associateVoter(1,"test");
    }

    @Test
    public void removeVoter() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        electionService.withdrawVoter(1,"test");

        verify(electionService,times(1)).withdrawVoter(1,"test");


    }

    @Test
    public void validateVoter() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);


        //Validate that voter is associated with an election
        when(electionService.validateVoter(1,"test")).thenReturn("Found");

        //Validate that voter is not associated with an election
        when(electionService.validateVoter(1,"wrongID")).thenReturn("Missing");
    }

    @Test
    public void associateCandidate() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        electionService.associateCandidate(1,"test");

        verify(electionService,times(1)).associateCandidate(1,"test");


    }

    @Test
    public void removeCandidate() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        electionService.withdrawCandidate(1,"test");

        verify(electionService,times(1)).withdrawCandidate(1,"test");
    }

    @Test
    public void validateCandidate() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        when(electionService.validateCandidate(1,"test")).thenReturn("Found");

        when(electionService.validateCandidate(1,"wrongID")).thenReturn("Missing");

    }

    @Ignore
    @Test
    public void viewCandidates() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        List<HashMap<String, String>> listofMaps = new ArrayList<HashMap<String, String>>();




    }

    @Test
    public void getPolicy() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        electionService.createPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policy);
    }

    @Test
    public void createPolicy() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        electionService.createPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policy);


    }

    @Test
    public void modifyPolicy() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        electionService.createPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policy);

        policy.setType("test2");
        policy.setFrequency(2);

        electionService.modifyPolicy(policy);

        verify(electionService,times(1)).modifyPolicy(policy);

    }
}