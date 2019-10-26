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

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
public class QuestionControllerTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.QuestionController QuestionController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.CandidateService candidateService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionService electionService;

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



    }

    @Test
    public void listQuestionsByCandidate() {




    }
}