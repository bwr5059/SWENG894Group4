package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao.CandidateConnectionDao;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;

@Service("candidateService")
public class CandidateServiceImpl implements CandidateService{
	
	CandidateConnectionDao connDao = new CandidateConnectionDao();
	
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
	
	//Add single user to db
	public String addCandidate(Candidate candidate) {
		//candidates = findAllCandidates();
		connDao.insertCandidate(candidate);
		//users.add(user);
		return "Success";
	}

}
