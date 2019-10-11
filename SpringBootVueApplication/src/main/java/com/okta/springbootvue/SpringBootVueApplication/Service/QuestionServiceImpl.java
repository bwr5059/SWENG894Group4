/*---------------------------------------------------------------------
|  Class QuestionServiceImpl
|
|  Purpose: Implementation of Question Services
|
|  Methods: viewQuestionsByCandidate
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.QuestionConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;

/**
 * QuestionServiceImpl Class - Implements QuestionService interface. Connects QuestionService class methods to database by
 * calling the connDao RetrieveConnection method and associated methods to execute statements.
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService{
	
	//Complete List of Existing Elections
	private static List<Question> questions;
	//private static List<Candidate> candidates;
	
	//Object to call all Election Queries
	QuestionConnectionDao connDao = new QuestionConnectionDao();
	
	/**
	 * findByID() - Finds and returns a user from the user table by ID. If user does not exist return null.
	 * @param id
	 * @return User
	*/
	public Question findById(int qID) {
		Question question = connDao.getQuestionByID(qID);
		return question;
	}
	
	/**
	 * viewQuestionsByCandidate() -
	 * @param canID
	*/
	public List<Question> viewQuestionsByCandidate(String canID) {
		questions= connDao.getQuestionsByCandidate(canID);
		return questions;
		
	}
	

}
