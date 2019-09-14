package src.main.java.com.okta.springbootvue.SpringBootVueApplication;

import lombok.*;  

import javax.persistence.Id;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Entity;  
  
@Entity  
@Data  
@NoArgsConstructor  
public class Election {  
      
  @Id @GeneratedValue  
  private Long electionId;  
  
  private String title;
  
  private Boolean closed = false;
  
  //Number of allowed candidates to be selected per voter
  private int numVotes = 1;
  
  //Total number of candidates for election
  private int numCandidates = 1;
  
  //Date voting closes
  private String date;
      
}
