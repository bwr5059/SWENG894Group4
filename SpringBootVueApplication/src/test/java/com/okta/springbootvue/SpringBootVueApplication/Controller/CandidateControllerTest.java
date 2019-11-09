package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")



public class CandidateControllerTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.CandidateController candidateController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.CandidateServiceImpl candidateService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.ElectionController electionController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionServiceImpl electionService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.UserController userController;


    Candidate candidate = new Candidate();

    Question question = new Question();

    Election election = new Election();

    User user = new User();

    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);

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

        question.setQID(1234);
        question.setCanID("test");
        question.setUserID("1234");
        question.setQuestion("test");
        question.setAnswer("test");

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

    }


    @Test
    public void listAllCandidates() {

        //candidateController.newCandidate(candidate);

        //Response from calling newCandidate method
        ResponseEntity<Candidate> newAddResponse = candidateController.newCandidate(candidate);

        //Check to see that method executed successfully
        assertThat(newAddResponse.getStatusCodeValue()).isEqualTo(201);

        //List response from calling listAllCandidates method
        ResponseEntity<List<Candidate>> canListResponse = candidateController.listAllCandidates();

        assertThat(canListResponse.getStatusCodeValue()).isNotEqualTo(201);

    }

    @Ignore
    @Test
    public void getCandidate() {

        userController.newUser(user,"candidate");

        electionController.newElection(election);

        //Response from calling newCandidate method
        ResponseEntity<Candidate> newAddResponse = candidateController.newCandidate(candidate);

        candidateController.newCandidate(candidate);

        //Check to see that method executed successfully
        assertThat(newAddResponse.getStatusCodeValue()).isEqualTo(201);

        ResponseEntity<Candidate> getCandidateResponse = candidateController.getCandidate("test");

        Candidate candidateAfterAdd = getCandidateResponse.getBody();

        when(candidateService.findById("test")).thenReturn(candidateAfterAdd);


    }

    @Test
    public void getCandidateName() {
    }

    @Test
    public void newCandidate() {

        ResponseEntity<Candidate> newCandidateResponse = candidateController.newCandidate(candidate);

        assertThat(newCandidateResponse.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void modifyCandidate() {
    }

    @Test
    public void answerQuestion() {

        ResponseEntity<Question> newQuestionResponse = candidateController.answerQuestion(question,1234);

        assertThat(newQuestionResponse.getStatusCodeValue()).isEqualTo(200);
    }
}