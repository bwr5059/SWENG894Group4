/*---------------------------------------------------------------------
|  Class Candidate
|
|  Purpose: Set up attributes for Candidate (Profile) Objects 
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
 * Candidate Class -
 */
public class Candidate {  
      
  @Id 
  private String canID;  
  
  private String userID;
  
  private String first_name;
  
  private String last_name;
  
  private String email;
  
  private int electionID;  
  
  private String about;
  
  private String education;
  
  private String employment;
  
  private String experience;
  
  private String contact;

  public String getCanID() {
    return this.canID;
  }

  public String getUserID() {
    return this.userID;
  }

  public String getFirst_name() {
    return this.first_name;
  }

  public String getLast_name() {
    return this.last_name;
  }

  public void setCanID(String candid) {
    this.canID = candid;
  }

  public void setUserID(String uid) {
    this.userID = uid;
  }
}
