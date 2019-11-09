package com.okta.springbootvue.SpringBootVueApplication.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)

@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
public class QuestionServiceImplTest {

    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.QuestionServiceImpl questionService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.QuestionConnectionDao connDao;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService userService;

    //New Question Object
    Question question = new Question();

    //Set Object Variable values before each test case
    @Before
    public void before() {

        MockitoAnnotations.initMocks(this);

        question.setQID(1);
        question.setCanID("1");
        question.setUserID("1");
        question.setQuestion("test");
        question.setAnswer("test");
    }

    @Test
    public void findById() {
        userService.addQuestion(question);

        when(questionService.findById(1)).thenReturn(question);
    }

    @Test
    public void viewQuestionsByCandidate() {
        List<Question> questionList1 = new ArrayList<Question>();
        questionList1.add(question);

        userService.addQuestion(question);

        String canID = question.getCanID();

        List<Question> questionReturnList = questionService.viewQuestionsByCandidate(canID);

        when(connDao.getQuestionsByCandidate(canID)).thenReturn(questionReturnList);
    }
}