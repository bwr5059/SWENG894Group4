package com.okta.springbootvue.SpringBootVueApplication.Service;

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

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
public class CandidateServiceImplTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.CandidateServiceImpl candidateService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.CandidateConnectionDao connDao;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.QuestionService questionService;

    //New User Object
      Candidate candidate = new Candidate();

    //New Question Object
     Question question = new Question();

    //Set Object Variable values before each test case
    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);

        candidate.setCanID("test");
        candidate.setUserID("test");
        candidate.setFirst_name("test");
        candidate.setLast_name("test");
        candidate.setEmail("test@test.com");
        candidate.setElectionID(1);
        candidate.setAbout("test");
        candidate.setEducation("test");
        candidate.setEmployment("test");
        candidate.setExperience("test");
        candidate.setContact("test");

        question.setQID(1);
        question.setCanID("1");
        question.setUserID("1");
        question.setQuestion("test");
        question.setAnswer("test");
    }

    @Test
    public void findAllCandidates() {
        List<Candidate> candidateList1 = new ArrayList<Candidate>();
        candidateList1.add(candidate);

        candidateService.addCandidate(candidate);

        List<Candidate> allCandidates = candidateService.findAllCandidates();

        assertNotNull(allCandidates);

        when(connDao.getCandidateList()).thenReturn(allCandidates);
    }

    @Test
    public void findById() {
        candidateService.addCandidate(candidate);

        when(candidateService.findById("test")).thenReturn(candidate);
    }

    @Test
    public void findByName() {
        candidateService.addCandidate(candidate);

        when(candidateService.findByName("test")).thenReturn(candidate);
    }

    @Test
    public void addCandidate() {
        candidateService.addCandidate(candidate);

        when(candidateService.findById(candidate.getCanID())).thenReturn(candidate);
    }

    @Test
    public void updateCandidate() {
        candidateService.addCandidate(candidate);

        candidate.setUserID("test1");
        candidate.setFirst_name("test1");
        candidate.setLast_name("test1");

        candidateService.updateCandidate(candidate);

        when(candidateService.findById("test1")).thenReturn(candidate);
    }

    @Test
    public void answerQuestion() {
    }
}