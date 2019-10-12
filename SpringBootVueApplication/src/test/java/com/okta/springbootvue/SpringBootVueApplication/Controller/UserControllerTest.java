package com.okta.springbootvue.SpringBootVueApplication.Controller;

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
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.UserController;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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


        User user2 = new User();

        user2.setId("test");
        user2.setType("Voter");
        user2.setAge(25);
        user2.setEthnicity("European");
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

        List<User> userList = null;
        userList.add(user);
        userList.add(user2);









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
    }

    @Test
    public void modifyUserType() {
    }

    @Test
    public void deleteUser() {
    }


}