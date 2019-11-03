package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
public class QuestionControllerTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.QuestionController questionController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.CandidateService candidateService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.QuestionService questionService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService userService;


    Candidate candidate = new Candidate();

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
    public void listQuestionsByCandidate() {

        //Add a candidate
        candidateService.addCandidate(candidate);
        when(candidateService.findById("test")).thenReturn(candidate);

        //Add a question
        userService.addQuestion(question);
        when(questionService.findById(1234)).thenReturn(question);

        //Call the listQuestionByCandidate method to get a response
        ResponseEntity<List<Question>> responseQuestionListAdd = questionController.listQuestionsByCandidate("test");

        //Get body of response
        List<Question> questionListFromResponse = responseQuestionListAdd.getBody();

        when(questionService.viewQuestionsByCandidate("test")).thenReturn(questionListFromResponse);
    }
}