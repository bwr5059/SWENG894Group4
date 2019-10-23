/*---------------------------------------------------------------------
|  Class Ballot
|
|  Purpose: Set up attributes for Ballot Objects 
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
 * Ballot Class -
 */
public class Ballot {  
      
  @Id  
  private int voteID;  
  
  private String userID;
  
  private int electionID;
  
  private String canID;
  
  private String first_name;
  
  private String last_name;
      
}
