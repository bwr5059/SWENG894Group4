package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")


public class QuestionControllerTest {

    @Test
    public void listQuestionsByCandidate() {
    }
}