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

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class ElectionServiceImplTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionServiceImpl electionService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ElectionConnectionDao connDao;

    //New Election Object
    Election election = new Election();

    //New Policy Object
    Policy policy = new Policy();

    //New User object
    User user = new User();

    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);


    }

    
    @Test
    public void findAllElections() {
    }

    @Test
    public void findElectionById() {
    }

    @Test
    public void addElection() {
    }

    @Test
    public void updateElection() {
    }

    @Test
    public void deleteElectionById() {
    }

    @Test
    public void associateVoter() {
    }

    @Test
    public void withdrawVoter() {
    }

    @Test
    public void validateVoter() {
    }

    @Test
    public void associateCandidate() {
    }

    @Test
    public void withdrawCandidate() {
    }

    @Test
    public void validateCandidate() {
    }

    @Test
    public void viewCandidates() {
    }

    @Test
    public void getPolicy() {
    }

    @Test
    public void createPolicy() {
    }

    @Test
    public void modifyPolicy() {
    }

    @Test
    public void getVotesByVoter() {
    }
}