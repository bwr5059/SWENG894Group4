package com.okta.springbootvue.SpringBootVueApplication.Dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.UserConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

public class UserConnectionDaoTest {

    private List<User> userList;

    @Mock
    private ConnectionDao cd;

    @Mock
    private Connection conn;

    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet rs;

    private User u;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(cd);
        when(conn.prepareStatement(any(String.class))).thenReturn(stmt);
        when(cd.RetrieveConnection()).thenReturn(conn);



        u = new User();

        u.setId("test");
        u.setType("Voter");
        u.setAge(25);
        u.setEthnicity("European");
        u.setGender("F");
        u.setAddress("160 Temp Drive");
        u.setCity("Philadelphia");
        u.setState("PA");
        u.setZip("12345");
        u.setFirst_name("Han");
        u.setLast_name("Solo");
        u.setProfile_complete(0);
        u.setUser_name("sw1");
        u.setRace("White");

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(u.getID());
        when(rs.getString(2)).thenReturn(u.getType());
        when(rs.getInt(3)).thenReturn(u.getAge());
        when(rs.getString(4)).thenReturn(u.getEthnicity());
        when(rs.getString(5)).thenReturn(u.getGender());
        when(rs.getString(6)).thenReturn(u.getAddress());
        when(rs.getString(7)).thenReturn(u.getCity());
        when(rs.getString(8)).thenReturn(u.getState());
        when(rs.getString(9)).thenReturn(u.getZip());
        when(rs.getString(10)).thenReturn(u.getFirst_name());
        when(rs.getString(11)).thenReturn(u.getLast_name());
        when(rs.getInt(12)).thenReturn(u.getProfile_complete());
        when(rs.getString(13)).thenReturn(u.getUser_name());
        when(rs.getString(14)).thenReturn(u.getRace());


    }


    @Test(expected=IllegalArgumentException.class)
    public void nullCreateThrowsException() {
        new UserConnectionDao().insertUser(null, null);
    }

    @Test
    public void getUserList() throws Exception {

        Connection conn = cd.RetrieveConnection();
        UserConnectionDao userConnectionDao = new UserConnectionDao();
        Statement stmt = conn.createStatement();

        rs=stmt.executeQuery("select * from user");


    }

    @Test
    public void getUserById() {
    }

    @Test
    public void insertUser() {

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
}