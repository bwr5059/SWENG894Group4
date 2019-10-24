package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class UserControllerTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.UserController UserController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao userConnectionDAO;


    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService userService;


    User user = new User();

    Question question = new Question();

    ConnectionDao connectionDao = new ConnectionDao();





    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);

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

        question.setQID(1);
        question.setCanID("1");
        question.setUserID("1");
        question.setQuestion("test");
        question.setAnswer("test");




    }

    @Test()
    public void listAllUsers() {

        List<User> userList1 = new ArrayList<User>();
        userList1.add(user);

        when(userService.findAllUsers()).thenReturn(userList1);

        List<User> userList2 = userService.findAllUsers();

        assertEquals(1, userList2.size());

    }

    @Test
    public void getUser() {

        when(userService.findById("test")).thenReturn(user);

        User user2 = userService.findById("test");

        assertEquals(25,user2.getAge());
        assertEquals("F",user2.getGender());
        assertEquals("PA",user2.getState());

    }

    @Test
    public void newUser() {

        userService.addUser(user,"Voter");

        verify(userService, times(1)).addUser(user,"Voter");

    }



    @Test
    public void modifyUser() {

        userService.addUser(user,"Voter");

        when(userService.findById("test")).thenReturn(user);

        user.setId("111");
        user.setType("Candidate");
        user.setAge(26);

        userService.updateUser(user);

        verify(userService, times(1)).updateUser(user);


    }

    @Test
    public void modifyUserType() {

        userService.addUser(user, "Voter");

        String type = "Candidate";

        userService.updateUserType(user.getId(),type);

        //verify(userService).updateUserType(user.getId(),type);
        verify(userService, times(1)).updateUserType(user.getId(),type);

    }

    @Test
    public void deleteUser() {

        userService.addUser(user, "Voter");

        userService.deleteUserById(user.getId());

        assertNull(userService.findById(user.getId()));

        //verify(userService, times(1)).deleteUserById("test");
    }


    @Test
    public void askQuestion() {

        userService.addQuestion(question);

        verify(userService, times(1)).addQuestion(question);


    }
}