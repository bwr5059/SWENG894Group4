/*---------------------------------------------------------------------
|  Class CandidateServiceImpl
|
|  Purpose: Implementation of Candidate Services
|
|  Methods: findAllCandidates, findById, findByName, addCandidate, updateCandidate
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

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.CandidateConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.QuestionConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;

@Service("candidateService")
public class CandidateServiceImpl implements CandidateService{
	
	CandidateConnectionDao connDao = new CandidateConnectionDao();
	QuestionConnectionDao questionConnDao = new QuestionConnectionDao();
	
	private static List<Candidate> candidates;
	
	/**
	 * findAllCandidates() - Retrieves all rows from candidate table.
	 * @return
	*/
	public List<Candidate> findAllCandidates() {
		try {
			candidates= connDao.getCandidateList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return candidates;
	}
	
	/**
	 * findByID() - Finds and returns a candidate from the candidate table by ID. If candidate does not exist return null.
	 * @param canID
	 * @return
	 */
	public Candidate findById(String canID) {
		Candidate candidate = connDao.getCandidateById(canID);
		return candidate;
	}
	
	/**
	 * findByName() - Finds and returns a candidate from the candidate table by First and Last Name. If candidate does not exist return null.
	 * @param canID
	 * @return
	 */
	public Candidate findByName(String name) {
		Candidate candidate = connDao.getCandidateByName(name);
		return candidate;
	}
	
	//Add single candidate to db
	public String addCandidate(Candidate candidate) {
		candidates = findAllCandidates();
		connDao.insertCandidate(candidate);
		candidates.add(candidate);
		return "Success";
	}
	
	/**
	 * updateCandidate() - Updates an existing candidate.
	 * @param candidate
	 */
	public void updateCandidate(Candidate candidate) {
		connDao.updateCandidate(candidate, candidates);
	}
	
	/**
	 * answerQuestion() - Adds an answer to a question entry.
	 * @param qID
	 * @param answer
	 */
	public void answerQuestion(Question question, int qID) {
		questionConnDao.insertAnswer(question, qID);
	}

}
