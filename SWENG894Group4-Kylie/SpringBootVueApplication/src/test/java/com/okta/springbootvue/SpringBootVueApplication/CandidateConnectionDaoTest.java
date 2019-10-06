package com.okta.springbootvue.SpringBootVueApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;

import java.sql.Connection;

@RunWith(SpringRunner.class)
@DataJpaTest

public class CandidateConnectionDaoTest {

    Connection conn;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.CandidateConnectionDao CandidateDao;


    @Autowired
    private src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.CandidateRepository candidateRepository;

    @Autowired
    private src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate Candidate;

    @Test
    public void getCandidateList() {
    }

    @Test
    public void getCandidateById() {

        Candidate candidate = CandidateDao.getCandidateById("testOther");

        Assert.assertEquals("swTest", candidate.getUserID());
        Assert.assertEquals("Luke", candidate.getFirst_name());
        Assert.assertEquals("Skywalker", candidate.getLast_name());
        return;

    }

    @Test
    public void getCandidateByName() {

        Candidate candidate = CandidateDao.getCandidateByName("Skywalker");

        Assert.assertEquals("swTest", candidate.getUserID());
        Assert.assertEquals("Luke", candidate.getFirst_name());
        return;
    }

    @Test
    public void insertCandidate() {


    }

    @Test
    public void updateCandidate() {
    }
}