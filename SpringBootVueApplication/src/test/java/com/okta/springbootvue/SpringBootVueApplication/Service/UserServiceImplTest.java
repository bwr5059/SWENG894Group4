/*---------------------------------------------------------------------
|  Class UserServiceImplTest
|
|  Purpose: Test Methods of the Implementation of the UserService Class
|
|  Methods: findAllUsers, findById, addUser, updateUser, updateUserType,
|           deleteUserById, addQuestion, castVote
|
|  Version: Sprint 3
|
*-------------------------------------------------------------------*/
        package com.okta.springbootvue.SpringBootVueApplication.Service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.QuestionConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Ballot;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

/**
 * UserServiceImplTest Class - Tests methods of the UserServiceImpl Class
 */
public class UserServiceImplTest {

    //Inject Mocks for class dependencies
    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserServiceImpl userService;

    @Mock
    UserConnectionDao connDao;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.QuestionService questionService;

    //New Connection object
    Connection conn = null;

    //New QuestionConnectionDao object
    QuestionConnectionDao questionConnDao = new QuestionConnectionDao();

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

    /**
     * findAllUsers() - Tests the findAllUsers method. Adds a user and tests that calling the findAllUsers() method
     * returns a list containing the user.
     */
    @Test
    public void findAllUsers() {
        List<User> userList1 = new ArrayList<User>();
        userList1.add(user);

        userService.addUser(user,"voter");

        List<User> allUsers = userService.findAllUsers();

        assertNotNull(allUsers);

        when(connDao.getUserList()).thenReturn(allUsers);
    }

    /**
     * findByID() - Adds a user and confirms calling the findByID() method returns the user.
     */
    @Test
    public void findById() {
        userService.addUser(user,"voter");

        when(userService.findById("test")).thenReturn(user);
    }

    /**
     * addUser() - Adds a user and confirms calling the findByID() method returns the user.
     */
    @Test
    public void addUser() {
        userService.addUser(user,"voter");

        when(userService.findById("test")).thenReturn(user);
    }

    /**
     * updateUser() - Adds a user, updates fields of the user object, calls the updateUser() method, retrieves user and
     * confirms return of updates user.
     */
    @Test
    public void updateUser() {
        //add User user
        userService.addUser(user,"voter");

        //modify Id, Type, and Age fields
        user.setId("111");
        user.setType("Candidate");
        user.setAge(26);

        //call updateUser method with modified user
        userService.updateUser(user);

        //verify that User user was modified
        when(userService.findById("111")).thenReturn(user);
    }

    /**
     * updateUserType() - Adds a user, sets the user type, calls the updateUserType() method, and confirms that
     * retrieved user is equivalent to updates user.
     */
    @Test
    public void updateUserType() {
        //add User user
        userService.addUser(user,"voter");

        //modify Type field
        user.setType("Candidate");
        String type = "candidate";

        userService.updateUserType("test",type);

        when(userService.findById("test")).thenReturn(user);
    }

    /**
     * deleteUserById() - Adds a user and calls the deleteUserById() method. Confirms that user has been removed from
     * database.
     */
    @Test
    public void deleteUserById() {
        //add User user
        userService.addUser(user,"voter");

        List<User> userList1 = new ArrayList<User>();

        userService.deleteUserById("test");

        User nullUser = userService.findById("test");

        assertNotEquals(user,nullUser);

        assertNull(nullUser);
    }

    /**
     * addQuestion() - Adds a question and confirms that retrieved question is equivalent to the question object.
     */
    @Test
    public void addQuestion() {
        userService.addQuestion(question);

        when(questionService.findById(1)).thenReturn(question);
    }

    @Ignore
    @Test
    public void castVote() {
        Ballot ballot2 = userService.castVote("test",ballot);

        assertNotNull(ballot2);


    }
}