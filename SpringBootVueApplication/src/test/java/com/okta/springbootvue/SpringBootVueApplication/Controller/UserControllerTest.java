package com.okta.springbootvue.SpringBootVueApplication.Controller;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.UserController;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class UserControllerTest {

    @InjectMocks
    UserControllerTest UserControllerTest;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao userConnectionDAO;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService userService;

    @Test
    public void listAllUsers() {


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


        List<User> userList1 = null;
        userList1.add(user);


        User user2 = UserController.newUser(user,"Voter");

        assertEquals(user.getID, user2.getID);

        List<User> users = userService.findAllUsers();

        assertEquals(userList1.size(),users.size());


    }

    @Test
    public void getUser() {

        List<User> testList = null;

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

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

        testList.add(user);

        when(userConnectionDAO.insertUser(user,testList)).thenReturn(testList);

        userService.addUser(user,"Voter");

        String ID = user.getID();

        User user2 = userService.findById(ID);

        assertEquals(user.getID(),user2.getID());
        assertEquals(user.getType(),user2.getType());


    }

    @Test
    public void testnewUser() {

        List<User> testList = null;

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        //User user = new User("test4","Voter",25,"European","F", "160 Temp Drive","Philadelphia", "PA","12345", "Han","Solo",0,"swl","White");

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

        testList.add(user);

        when(userConnectionDAO.insertUser(user,testList)).thenReturn(testList);

        ResponseEntity<Object> responseEntity = UserController.newUser(user,"Voter");

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);

        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/test");


    }

    @Test
    public void modifyUser() {

        User user = new User();
        User user2 = new User();

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


        user2.setId("test");
        user2.setType("Voter");

        //Update to Age
        user2.setAge(30);
        //Update to Ethnicity
        user2.setEthnicity("Asian");
        user2.setGender("F");
        user2.setAddress("160 Temp Drive");
        user2.setCity("Philadelphia");
        user2.setState("PA");
        user2.setZip("12345");
        user2.setFirst_name("Han");
        user2.setLast_name("Solo");
        user2.setProfile_complete(0);
        user2.setUser_name("sw1");
        user2.setRace("White");

        //Get ID of user
        String ID = user.getID();

        //Add User user as currentUser
        User originalUserAdd = UserController.newUser(user,user.getType());

        originalUserAdd.setId(user2.getId());
        originalUserAdd.setEmail(user2.getEmail());
        originalUserAdd.setType(user2.getType());
        originalUserAdd.setAge(user2.getAge());
        originalUserAdd.setEthnicity(user2.getEthnicity());
        originalUserAdd.setGender(user2.getGender());
        originalUserAdd.setAddress(user2.getAddress());
        originalUserAdd.setCity(user2.getCity());
        originalUserAdd.setState(user2.getState());
        originalUserAdd.setZip(user2.getZip());
        originalUserAdd.setFirst_name(user2.getFirst_name());
        originalUserAdd.setLast_name(user2.getLast_name());
        originalUserAdd.setProfile_complete(user2.getProfile_complete());
        originalUserAdd.setUser_name(user2.getUser_name());
        originalUserAdd.setRace(user2.getRace());

        verify(userService).updateUser(originalUserAdd);

    }

    @Test
    public void modifyUserType() {

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

        //Add User user as currentUser
        User originalUserAdd = UserController.newUser(user,user.getType());

        String type = "Candidate";

        verify(userService).updateUserType(originalUserAdd.getID(),type);

    }


    @Test
    public void deleteUser() {

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

        //Add User user as currentUser
        User originalUserAdd = UserController.newUser(user,user.getType());

        userService.deleteUserById(originalUserAdd.getID());

        assertNull(userService.findById(originalUserAdd.getID()));



    }


}