package com.okta.springbootvue.SpringBootVueApplication.Service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.*;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.*;

import java.util.List;

import static org.mockito.Mockito.mock;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class UserServiceImplTest {



    private static List<src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User> users;

    @Mock
    private UserConnectionDao connDao;

    public User user;
    public UserServiceImpl userServiceImpl;

    @Test
    public void findAllUsers() {

    }

    @Test
    public void findById() {
        MockitoAnnotations.initMocks(this);
        userServiceImpl = new UserServiceImpl();
        user = new User();

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


        userServiceImpl.findById("test");
        userServiceImpl.addUser(user,"Voter");

        Mockito.verify(connDao).getUserById("1");

    }

    @Test
    public void addUser() throws Exception{

        user = new User();

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


        userServiceImpl = mock(UserServiceImpl.class);

        Assert.assertNotNull(userServiceImpl.findByID("test"));




        //when(userServiceImpl.addUser(user,"Voter")).thenReturn("Success");


    }

    @Test
    public void updateUser() {
    }

    @Test
    public void updateUserType() {
    }

    @Test
    public void deleteUserById() {
    }
}