package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
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


    Candidate candidate = new Candidate();

    Candidate candidate2 = new Candidate();

    Question question = new Question();

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

        //List<Candidate> canListResponse2 = canListResponse.getBody();

        //assertNotNull(canListResponse2);


        //candidateService.addCandidate(candidate);

        //when(candidateService.findById("test")).thenReturn(candidate);

        //List<Candidate> candidateList = new ArrayList<Candidate>();
        //candidateList.add(candidate);

        //when(candidateService.findAllCandidates()).thenReturn(candidateList);

        //assertEquals(canListResponse2,candidateList);

    }

    @Test
    public void getCandidate() {
        //Response from calling newCandidate method
        //ResponseEntity<Candidate> newAddResponse = candidateController.newCandidate(candidate);

        //Check to see that method executed successfully
        //assertThat(newAddResponse.getStatusCodeValue()).isEqualTo(201);

        //ResponseEntity<Candidate> newGetResponse = candidateController.getCandidate("test");

        //Check to see that method executed successfully
        //assertThat(newGetResponse.getStatusCodeValue()).isEqualTo(201);

        candidateService.addCandidate(candidate);

        when(candidateService.findById("test")).thenReturn(candidate);

        candidate2 = candidateService.findById("test");

        assertEquals("test", candidate2.getUserID());
        assertEquals("test", candidate2.getFirst_name());
        assertEquals("test", candidate2.getLast_name());
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