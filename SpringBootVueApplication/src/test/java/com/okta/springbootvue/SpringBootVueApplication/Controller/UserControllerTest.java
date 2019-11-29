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
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Ballot;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class UserControllerTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.UserController userController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.QuestionService questionService;


    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService userService;

    //New User Object
    User user = new User();

    //New Question Object
    Question question = new Question();

    //New Ballot Object
    Ballot ballot = new Ballot();

    //Set Object Variable values before each test case
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

        ballot.setBallotID(1234);
        ballot.setUserID("test");
        ballot.setElectionID(1234);
        ballot.setCanID("test");
        ballot.setFirst_name("test");
        ballot.setLast_name("test");
    }

    @Test()
    public void listAllUsers() {

        List<User> userList1 = new ArrayList<User>();
        userList1.add(user);

        ResponseEntity<User> addUserResponse = userController.newUser(user,"voter");

        userController.newUser(user,"voter");

        //Check to see that method executed successfully by returned status code
        assertThat(addUserResponse.getStatusCodeValue()).isEqualTo(201);

        ResponseEntity<List<User>> listUsersResponse = userController.listAllUsers();

        List<User> allUsersList = listUsersResponse.getBody();

        when(userService.findAllUsers()).thenReturn(allUsersList);

    }

    @Test
    public void getUser() {

        //UserService UserService;

        ResponseEntity<User> addUserResponse = userController.newUser(user,"voter");

        userController.newUser(user,"voter");

        //Check to see that method executed successfully by returned status code
        assertThat(addUserResponse.getStatusCodeValue()).isEqualTo(201);

        ResponseEntity<User> getUserResponse = userController.getUser("test");

        User userAfterAdd = getUserResponse.getBody();

        when(userService.findById("test")).thenReturn(userAfterAdd);

        //Bad getUser request
        //ResponseEntity<User> badGetUserResponse = userController.getUser("test2");

        //assertEquals(404,badGetUserResponse.getStatusCodeValue());

        //when(userService.findById("test2")).thenReturn(badGetUserResponse.getBody());



    }

    @Test
    public void newUser() {

        ResponseEntity<User> addUserResponse = userController.newUser(user,"voter");

        //Check to see that method executed successfully by returned status code
        assertThat(addUserResponse.getStatusCodeValue()).isEqualTo(201);

    }


    @Test
    public void modifyUser() {

        ResponseEntity<User> addUserResponse = userController.newUser(user,"voter");

        userController.newUser(user,"voter");

        //Check to see that method executed successfully by returned status code
        assertThat(addUserResponse.getStatusCodeValue()).isEqualTo(201);

        user.setId("111");
        user.setType("Candidate");
        user.setAge(26);

        ResponseEntity<User> modifyUserResponse = userController.modifyUser(user,"test");

        User userAfterModify = modifyUserResponse.getBody();

        when(userService.findById("test")).thenReturn(userAfterModify);
    }

    @Test
    public void modifyUserType() {

        ResponseEntity<User> addUserResponse = userController.newUser(user,"voter");

        userController.newUser(user,"voter");

        //Check to see that method executed successfully by returned status code
        assertThat(addUserResponse.getStatusCodeValue()).isEqualTo(201);

        user.setType("candidate");

        ResponseEntity<User> modifyUserType = userController.modifyUserType("test","candidate");

        User userAfterModify = modifyUserType.getBody();

        when(userService.findById("test")).thenReturn(userAfterModify);
    }

    @Test
    public void deleteUser() {

        ResponseEntity<User> addUserResponse = userController.newUser(user,"voter");

        userController.newUser(user,"voter");

        //Check to see that method executed successfully by returned status code
        assertThat(addUserResponse.getStatusCodeValue()).isEqualTo(201);

        ResponseEntity<User> deleteUserResponse = userController.deleteUser("test");

        assertThat(deleteUserResponse.getStatusCodeValue()).isEqualTo(404);
    }


    @Test
    public void askQuestion() {

        ResponseEntity<Question> addQuestionResponse = userController.askQuestion(question);

        //Check to see that method executed successfully by returned status code
        assertThat(addQuestionResponse.getStatusCodeValue()).isEqualTo(201);

    }


    @Test
    public void castVote() {

        ResponseEntity<Ballot> castVoteResponse = userController.castVote("test", ballot);

        //Check to see that method executed successfully by returned status code
        assertThat(castVoteResponse.getStatusCodeValue()).isEqualTo(201);
    }
}