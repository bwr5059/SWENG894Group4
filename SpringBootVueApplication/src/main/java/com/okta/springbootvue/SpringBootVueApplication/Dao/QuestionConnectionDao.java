/*---------------------------------------------------------------------
|  Class QuestionConnectionDao
|
|  Purpose: Question Database Queries
|
|  Methods: getQuestionsByCandidate, insertQuestion
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
	 * getQuestionByID() - Performs select MySQL statement to retrieve question from candidateQuestion table.
	 * @param qID
	 * @return Question List
	 */
	public Question getQuestionByID(int qID){
		Question question = new Question();
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "SELECT * FROM candidateQuestion WHERE qID=?"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			stmt.setInt(1,qID);
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next())  {
				question.setQID(rs.getInt(1));
				question.setCanID(rs.getString(2));
				question.setUserID(rs.getString(3));
				question.setQuestion(rs.getString(4));
				question.setAnswer(rs.getString(5));
			}
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return question;
	}
	
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
	
	/**
	 * insertQuestion() - Performs insert MySQL statement to add question to candidateQuestion table.
	 * @param canID
	 * @return Question List
	 */
	public void insertQuestion(Question question){
		List<Question> questionList = new ArrayList<>();
		
		try {
			Connection conn = connectionDao.RetrieveConnection();
			String sql = "INSERT INTO candidateQuestion(canID, userID, question, answer) VALUES (?,?,?,?)"; 
			PreparedStatement stmt=conn.prepareStatement(sql); 
			
			stmt.setString(1,question.getCanID());
			stmt.setString(2,question.getUserID());
			stmt.setString(3,question.getQuestion());
			stmt.setString(4,question.getAnswer());	 
			stmt.executeUpdate();
			
			connectionDao.ReleaseConnection(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * insertAnswer() - Updates a question in the candidateQuestion database table with received values using MySQL statement.
	 * @param id
	 * @param answer
	 * @return void
	 */
	public void insertAnswer(Question question, int qID){
		try {
			Connection conn = connectionDao.RetrieveConnection();
		String sql = "UPDATE candidateQuestion SET answer=? WHERE qID=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,question.getAnswer());
		stmt.setInt(2,qID);

		stmt.executeUpdate(); 
		connectionDao.ReleaseConnection(conn);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
