/*---------------------------------------------------------------------
|  Class Question
|
|  Purpose: Set up attributes for Question Objects 
|
|  Version: Sprint 2
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model;

import lombok.*;  
import javax.persistence.Id;  
import javax.persistence.Entity;  
  
@Entity  
@Data  
@NoArgsConstructor  
/**
 * Question Class -
 */
public class Question {  
      
  @Id  
  private int qID;  
  
  //Id for Candidate Profile
  //Candidate being asked a question
  private String canID;
  
  //User asking the question
  private String userFirstName;

  private String userLastName;

  private String userID;
  
  private String question;
  
  private String answer;
      
}
