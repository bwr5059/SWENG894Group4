/*---------------------------------------------------------------------
|  Class QuestionController
|
|  Purpose: Set up Question REST Endpoints
|
|  Methods: listQuestionsByCandidate
|
|  Version: Sprint 2
|  
*-------------------------------------------------------------------*/
package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.CandidateService;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.QuestionService;

import java.util.HashMap;
import java.util.List;
/**
 * Class QuestionController - Returns question object and data using CRUD methods.
 */
@RestController
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	CandidateService candidateService;

	/**
	 * listQuestionsByCandidate() - Takes a canID as a parameter. View questions by candidate.
	 * @param canID
	 * @return
	 */
	@GetMapping("/question/viewQuestions/{canID}")
	public List<HashMap> listQuestionsByCandidate(@PathVariable("canID") String canID){
		Candidate candidate = candidateService.findById(canID);

		if (candidate == null) {
			//return new ResponseEntity<List<Question>>(HttpStatus.NOT_FOUND);
		}

		List<HashMap> questions = questionService.viewQuestionsByCandidate(canID);

		return questions;
	}
  
}
