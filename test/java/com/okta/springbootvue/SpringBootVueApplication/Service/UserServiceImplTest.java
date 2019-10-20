package com.okta.springbootvue.SpringBootVueApplication.Service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserServiceImpl userServiceImpl;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao userConnectionDao;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.QuestionConnectionDao questionConnectionDao;

    User user = new User();

    @Before
    public void init() {
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
    }

    @Test
    public void findAllUsers() {

        List<User> userList = new ArrayList<User>();
        userList.add(user);

        when(userConnectionDao.getUserList()).thenReturn(userList);

        List<User> userList2 = userServiceImpl.findAllUsers();

        assertEquals(1, userList2.size());
    }

    @Test
    public void findById() {
    }

    @Test
    public void addUser() {
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

    @Test
    public void addQuestion() {
    }
}