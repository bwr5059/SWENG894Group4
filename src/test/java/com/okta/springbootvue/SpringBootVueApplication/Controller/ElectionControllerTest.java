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
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

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

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.CandidateController candidateController;

    Election election = new Election();

    User user = new User();

    Policy policy = new Policy();

    Candidate candidate = new Candidate();

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
        election.setClose_date("date");

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

    @Test
    public void associateVoter() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"voter");

        //verify(userService,times(1)).addUser(user,"voter");

        when(userService.findById("test")).thenReturn(user);

        electionController.associateVoter(1,"test");

        //ResponseEntity<Election> associateVoterResponse = electionController.associateVoter(1,"test");

        //assertThat(associateVoterResponse.getStatusCodeValue()).isEqualTo(200);

        //when(electionController.validateVoter(1, "test")).thenReturn();

        String test = electionController.validateVoter(1,"test");

        //assertEquals("Found",test);
    }

    @Test
    public void removeVoter() {

        electionController.newElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userController.newUser(user,"voter");

        when(userService.findById("test")).thenReturn(user);

        electionController.removeVoter(1,"test");

        when(electionController.validateVoter(1,"test")).thenReturn("Missing");


    }

    @Ignore
    @Test
    public void validateVoter() {

        electionController.newElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userController.newUser(user,"voter");

        when(userService.findById("test")).thenReturn(user);

        electionController.associateVoter(1,"test");

        //Validate that voter is associated with an election
        when(electionService.validateVoter(1,"test")).thenReturn("Found");

        //Validate that voter is not associated with an election
        when(electionService.validateVoter(1,"wrongID")).thenReturn("Missing");
    }

    @Test
    public void associateCandidate() {

        electionController.newElection(election);

        when(electionService.findElectionById(1)).thenReturn(election);

        userService.addUser(user,"Voter");

        userController.newUser(user,"voter");

        when(userService.findById("test")).thenReturn(user);

        electionController.associateCandidate(1,"test");

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

    @Test
    public void validateCandidate() {

        electionController.newElection(election);

        candidateController.newCandidate(candidate);

        electionController.associateCandidate(1,"test");

        electionController.validateCandidate(1,"test");

        when(electionService.validateCandidate(1,"test")).thenReturn("Found");

        when(electionService.validateCandidate(2,"wrongID")).thenReturn("Missing");

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

        electionController.createPolicy(policy);

        ResponseEntity<Policy> getPolicyResponse = electionController.getPolicy(1);

        Policy policyAfterGet = getPolicyResponse.getBody();

        when(electionService.getPolicy(1)).thenReturn(policyAfterGet);

    }

    @Test
    public void createPolicy() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        ResponseEntity<Policy> addPolicyResponse = electionController.createPolicy(policy);

        electionController.createPolicy(policy);

        Policy policyAfterAdd = addPolicyResponse.getBody();

        when(electionService.getPolicy(1)).thenReturn(policyAfterAdd);
    }


    @Test
    public void modifyPolicy() {

        ResponseEntity<Election> addElectionResponse = electionController.newElection(election);

        //Check to see that method executed successfully by returned status code
        assertThat(addElectionResponse.getStatusCodeValue()).isEqualTo(201);

        electionController.newElection(election);

        electionController.createPolicy(policy);

        policy.setType("test2");
        policy.setFrequency(2);

        ResponseEntity<Policy> afterModifyResponse = electionController.modifyPolicy(policy);

        Policy policyafterAdd = afterModifyResponse.getBody();

        electionController.modifyPolicy(policy);

        when(electionService.getPolicy(1)).thenReturn(policyafterAdd);
    }
}