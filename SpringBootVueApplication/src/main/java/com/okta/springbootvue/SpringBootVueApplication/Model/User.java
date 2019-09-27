package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model;

import lombok.*;  

import javax.persistence.Id;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Entity;  
  
@Entity  
@Data  
@NoArgsConstructor  
public class User {  
      
  @Id 
  private String id;  
  
  private String email;
  
  private String user_name;

  @NonNull
  private String first_name;  
  
  private String last_name;
  
  //Default Voter enum type
  //Other options: Candidate, Admin
  private String type;
  
  private int age;
  
  private String ethnicity;
    
  private String gender;
  
  private int profile_complete = 0;
  
  private String address;
  
  private String city;
  
  private String state;
  
  private String zip;
      
}
