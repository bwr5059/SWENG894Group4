package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Policy;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.UserController userController;

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


    }

    @Test
    public void listAllElections() {

        List<Election> electionList = new ArrayList<Election>();
        electionList.add(election);

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        Assertions.assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        ResponseEntity<List<Election>> listElectionsResponse = electionController.listAllElections();

        List<Election> allElectionsList = listElectionsResponse.getBody();

        when(electionService.findAllElections()).thenReturn(allElectionsList);
    }


    @Test
    public void getElection() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        Assertions.assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        ResponseEntity<Election> getElectionResponse = electionController.getElection(1);

        Election electionAfterAdd = getElectionResponse.getBody();

        when(electionService.findElectionById(1)).thenReturn(electionAfterAdd);
    }

    @Test
    public void newElection() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void modifyElection() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        //when(electionService.findElectionById(1)).thenReturn(election);

        election.setElectionID(2);
        election.setTitle("test2");
        election.setClosed(1);

        ResponseEntity<Election> modifyElectionResponse = electionController.modifyElection(1,election);

        Election electionAfterModify = modifyElectionResponse.getBody();

        when(electionService.findElectionById(1)).thenReturn(electionAfterModify);
    }

    @Test
    public void deleteElection() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        ResponseEntity<Election> deleteElectionResponse = electionController.deleteElection(1);

        assertThat(deleteElectionResponse.getStatusCodeValue()).isEqualTo(404);
    }

    @Ignore
    @Test
    public void associateVoter() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        userService.addUser(user,"voter");

        verify(userService,times(1)).addUser(user,"voter");

        ResponseEntity<Election> associateVoterResponse = electionController.associateVoter(1,"test");

        assertThat(associateVoterResponse.getStatusCodeValue()).isEqualTo(200);
        //when(electionService.findElectionById(1)).thenReturn(election);

        //userService.addUser(user,"Voter");

        //when(userService.findById("test")).thenReturn(user);

        //electionService.associateVoter(1,"test");

        //verify(electionService,times(1)).associateVoter(1,"test");
    }

    @Ignore
    @Test
    public void removeVoter() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        electionService.withdrawVoter(1,"test");

        verify(electionService,times(1)).withdrawVoter(1,"test");


    }

    @Ignore
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

    @Ignore
    @Test
    public void associateCandidate() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        electionService.associateCandidate(1,"test");

        verify(electionService,times(1)).associateCandidate(1,"test");


    }

    @Ignore
    @Test
    public void removeCandidate() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        electionService.withdrawCandidate(1,"test");

        verify(electionService,times(1)).withdrawCandidate(1,"test");
    }

    @Ignore
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

    @Ignore
    @Test
    public void getPolicy() {

        electionService.addElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        electionService.createPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policy);
    }

    @Ignore
    @Test
    public void createPolicy() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        ResponseEntity<Policy> addPolicyResponse = electionController.createPolicy(policy);

        electionController.createPolicy(policy);

        assertThat(addPolicyResponse.getStatusCodeValue()).isEqualTo(200);

        //electionService.addElection(election);

        //when(electionService.findElectionById(1)).thenReturn(election);

        //electionService.createPolicy(policy);

        //when(electionService.getPolicy(1)).thenReturn(policy);


    }

    @Ignore
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