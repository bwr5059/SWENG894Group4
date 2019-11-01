/*---------------------------------------------------------------------
|  Class Policy
|
|  Purpose: Set up attributes for Policy Objects 
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
public class Policy {  
      
  @Id  
  private int electionID;  
  
  private String type;
  
  private int frequency;
  
  private int num_votes;
  
  private int write_in;

  private int abstain;
      
}
