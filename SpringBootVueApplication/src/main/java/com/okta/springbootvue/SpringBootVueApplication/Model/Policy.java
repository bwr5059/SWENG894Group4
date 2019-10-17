/*---------------------------------------------------------------------
|  Class Policy
|
|  Purpose: Set up attributes for Policy Objects 
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
 * Question Class -
 */
public class Policy {  
      
  @Id  
  private int electionID;  
  
  private int frequency;
  
  private int num_votes;
  
  private String type;
      
}
