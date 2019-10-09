/*---------------------------------------------------------------------
|  Class QuestionConnectionDao
|
|  Purpose: Question Database Queries
|
|  Methods: getQuestionsByCandidate
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Question;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Candidate;

/**
 * QuestionConnectionDao Class - Connects to MySQL database vision-database and performs queries through methods to update
 * database.
 */
public class QuestionConnectionDao {
	ConnectionDao connectionDao = new ConnectionDao();
	
	/**
	 * getQuestionsByCandidate() - Performs select MySQL statement to retrieve questions from candidateQuestion table.
	 * @param canID
	 * @return Question List
	 */
	public List<Question> getQuestionsByCandidate(String canID){
		List<Question> questionList = new ArrayList<>();
		
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM candidateQuestion WHERE canID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setString(1,canID);
			 
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				Question question = new Question();
				question.setQID(rs.getInt(1));
				question.setCanID(rs.getString(2));
				question.setUserID(rs.getString(3));
				question.setQuestion(rs.getString(4));
				question.setAnswer(rs.getString(5));
				questionList.add(question);
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return questionList;
	}
}

