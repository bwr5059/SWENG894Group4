package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.*;


import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Before
    public void before() {
        User user = new User();

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
    }


    @Test
    public void listAllUsers() {

        List<User> userList1 = null;
        userList1.add(user);

        userService.addUser(user,"Voter");

        List<User> userList2 = userConnectionDAO.getUserList();

        assertNotNull(userList2);

        assertEquals(userList1.get(0),userList2.get(0));


    }

    @Test
    public void getUser() {

        List<User> testList = null;

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        testList.add(user);

        when(userConnectionDAO.insertUser(user,testList)).thenReturn(testList);

        userService.addUser(user,"Voter");

        String ID = user.getID();

        User user2 = userService.findById(ID);

        assertEquals(user.getID(),user2.getID());
        assertEquals(user.getType(),user2.getType());
    }

    @Test
    public void newUser() {

        userService.addUser(user, "Voter");

        User user2 = userService.findById(user.getId());

        assertEquals(user.getAge(), user2.getAge());

    }



    @Test
    public void modifyUser() {

        userService.addUser(user, "Voter");

        user.setType("Candidate");
        user.setAge(26);

        //verify updateUser was called
        verify(userService).updateUser(user);

        User user2 = userService.findById(user.getId());

        assertEquals(user2.getType(),"Candidate");

        assertEquals(user2.getAge(), 26);


    }

    @Test
    public void modifyUserType() {

        userService.addUser(user, "Voter");

        String type = "Candidate";

        verify(userService).updateUserType(user.getId(),type);


    }

    @Test
    public void deleteUser() {

        userService.addUser(user, "Voter");

        userService.deleteUserById(user.getId());

        assertNull(userService.findById(user.getId()));
    }


    @Ignore
    @Test
    public void askQuestion() {

        Question question = new Question();
        Candidate candidate = new Candidate();
        Election election = new Election();

        election.setElectionID(1);
        election.setTitle("Test");
        election.setClosed(1);
        election.setAdmin1(1);
        election.setAdmin2(2);
        election.setAdmin3(3);
        election.setAdmin4(4);
        election.setAdmin5(5);
        election.setAdmin6(6);
        election.setChoice1("one");
        election.setChoice2("two");
        election.setChoice3("three");
        election.setChoice4("four");
        election.setChoice5("five");
        election.setClose_date("10-20-2019");
        election.setClose_time("5");
        election.setNum_candidates(3);
        election.setNum_votes(1);
        election.setStart_date("9-29-2019");
        election.setStart_time("8");
        election.setDescription("Description");

        candidate.setCanID(1234);
        candidate.setUserID("1234");
        candidate.setFirst_name("John");
        candidate.setLast_name("Doe");
        candidate.setEmail("test@test.com");
        candidate.setElectionID(1);


        question.setQID(1234);
        question.
    }
}