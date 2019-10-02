/*---------------------------------------------------------------------
|  Class User
|
|  Purpose: Set up attributes for User Objects 
|
|  Version: Sprint 1
|  
*-------------------------------------------------------------------*/

package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model;

import lombok.*;  

import javax.persistence.Id;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Entity;  
  
@Entity  
@Data  
@NoArgsConstructor  
/**
 * User Class -
 */
public class User {  
      
  @Id 
  private String id;  
  
  private String email;
  
  //Default Voter enum type
  //Other options: Candidate, Admin
  private String type;
  
  private int age;
  
  private String ethnicity;
  
  private String gender;
  
  private String address;
  
  private String city;
  
  private String state;
  
  private String zip;
  
  private String first_name;  
  
  private String last_name;
  
  //User registration state
  //Automatically set to no or 0
  private int profile_complete = 0;
  
  private String user_name;

  private String race;
    
}
