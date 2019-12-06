/*---------------------------------------------------------------------
|  Class Election
|
|  Purpose: Set up attributes for Election Objects 
|
|  Version: Sprint 3
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
  
  //Election ending date and time
  private String close_date;
  
  private String close_time;
  
  //Number of candidates
  private int num_candidates;
  
  //Number of votes allowed per user
  private int num_votes;
  
  //Election start date and time
  private String start_date;
  
  private String start_time;
  
  private String description;
  
  private String election_key;
      
}
