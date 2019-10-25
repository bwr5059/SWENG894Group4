/*---------------------------------------------------------------------
|  Class Election
|
|  Purpose: Set up attributes for Election Objects 
|
|  Version: Sprint 1
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
 * Election Class -
 */
public class Election {  
      
  @Id  
  private int electionID;  
  
  private String title;
  
  //Election state
  private int closed = 0;
  
  //Election Administrators
  private int admin1;
  private int admin2;
  private int admin3;
  private int admin4;
  private int admin5;
  private int admin6;
  
  //Election Choices
  private String choice1;
  private String choice2;
  private String choice3;
  private String choice4;
  private String choice5;
  
  //Election ending date and time
  private String close_date;
  
  private String close_time;
  
  //Number of candidates
  private int num_candidates;
  
  //Number of votes allowed per user
  private int num_votes;
  
  //Election start date,time, and key
  private String start_date;
  
  private String start_time;
  
  private String description;

  private String key;
      
}
