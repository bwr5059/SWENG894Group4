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
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

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


        User user = new User();

        @Before
    public void before() {


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

        System.out.println(userList1.size());


    }

    @Test
    public void getUser() {

        List<User> testList = null;

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        testList.add(user);

        when(userConnectionDAO.insertUser(user,testList)).thenReturn(testList);

        userService.addUser(user,"Voter");

        String ID = user.getId();

        User user2 = userService.findById(ID);

        assertEquals(user.getId(),user2.getId());
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

        userService.updateUser(user);
        //verify updateUser was called
        //verify(userService).updateUser(user);

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


    }
}