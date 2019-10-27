package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
public class QuestionControllerTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.QuestionController QuestionController;

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

        candidateService.addCandidate(candidate);

        when(candidateService.findById("test")).thenReturn(candidate);

        userService.addQuestion(question);

        when(questionService.findById(1234)).thenReturn(question);

        List<Question> questionList = new ArrayList<>();

        questionList.add(question);



        when(questionService.viewQuestionsByCandidate("test")).thenReturn(questionList);

    }
}