package com.okta.springbootvue.SpringBootVueApplication.Dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Statement;

public class ConnectionDaoTest {

    @InjectMocks private src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.ConnectionDao ConnectionDao;

    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveConnectionTest() throws Exception {

        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
    }

    @Test
    public void releaseConnection() {
    }
}