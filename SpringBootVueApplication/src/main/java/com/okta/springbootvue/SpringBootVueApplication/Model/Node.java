/*---------------------------------------------------------------------
|  Class Node
|
|  Purpose: Set up attributes for Node Objects for Decision Tree
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
 * Question Class -
 */
public class Node {  
      
  @Id  
  private int idNode;  
  
  private String type;
  
  private int left;
  
  private int right;
  
      
}
