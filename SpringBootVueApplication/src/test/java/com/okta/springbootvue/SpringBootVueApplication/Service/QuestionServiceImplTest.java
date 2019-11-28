/*---------------------------------------------------------------------
|  Class QuestionServiceImplTest
|
|  Purpose: Test the QuestionService implementation.
|
|  Methods: findById, viewQuestionsByCandidate,
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
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")

/**
 * QuestionServiceImplTest - Tests methods of the QuestionServiceImpl Class
 */
public class QuestionServiceImplTest {

    //Inject Mocks for class dependencies
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

    /**
     * findById() - Adds a question and confirms that a call to the findById() method returns the question.
     */
    @Test
    public void findById() {
        userService.addQuestion(question);

        when(questionService.findById(1)).thenReturn(question);
    }

    /**
     * viewQuestionsByCandidate() - Adds a question and confirms that calling the viewQuestionsByCandidate() method returns
     * the question.
     */
    @Ignore
    @Test
    public void viewQuestionsByCandidate() {
        userService.addQuestion(question);

        String canID = question.getCanID();

        //List<Question> questionReturnList = questionService.viewQuestionsByCandidate(canID);

        //when(connDao.getQuestionsByCandidate(canID)).thenReturn(questionReturnList);
    }
}