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
  
  private String email;

  @NonNull
  private String firstName;  
  
  private String lastName;
  
  //Default Voter enum type
  //Other options: Candidate, Admin
  private String type;
  
  private int age;
  
  private String ethnicity;
  
  private String race;
  
  private String gender;
  
  private boolean profileComplete = false;
  
  private String address;
  
  private String city;
  
  private String state;
  
  private int zip;
      
}
