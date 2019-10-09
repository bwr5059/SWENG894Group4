/*---------------------------------------------------------------------
|  Class QuestionService
|
|  Purpose: Define Question Services to be Implemented
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service;

import java.util.List;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;

/**
 * QuestionService Class - Interface for QuestionService.
 */
public interface QuestionService {

	//View Questions by Candidate
	List<Question> viewQuestionsByCandidate(String canID);
		
}
