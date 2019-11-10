package com.okta.springbootvue.SpringBootVueApplication.Dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Ballot;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

import java.sql.Connection;

import static java.sql.DriverManager.getConnection;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class UserConnectionDaoTest {

    @InjectMocks
    UserConnectionDao userConnectionDao;

    @Mock
    ConnectionDao connectionDao;

    User user = new User();

    Ballot ballot = new Ballot();

    @Before
    public void Before() {
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

        ballot.setBallotID(1234);
        ballot.setUserID("test");
        ballot.setElectionID(1234);
        ballot.setCanID("test");
        ballot.setFirst_name("test");
        ballot.setLast_name("test");

    }

    @Test
    public void getMaxID() {
    }

    @Test
    public void getUserList() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void insertUser() {
        Connection conn = connectionDao.RetrieveConnection();
        //conn.setAutoCommit(false);


    }

    @Test
    public void updateUser() {
    }

    @Test
    public void updateUserType() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void insertVote() {
    }

    @Test
    public void updateVote() {
    }
}