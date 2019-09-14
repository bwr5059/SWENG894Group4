package src.main.java.com.okta.springbootvue.SpringBootVueApplication;

import lombok.*;  

import javax.persistence.Id;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Entity;  
  
@Entity  
@Data  
@NoArgsConstructor  
public class User {  
      
  @Id @GeneratedValue  
  private Long id;  
  
  private String userName;

  @NonNull
  private String firstName;  
  
  private String lastName;
  
  //Default Voter enum type
  //Other options: Candidate, Admin
  private String type = "Voter";
  
  private int age;
  
  private String ethnicity;
      
}
