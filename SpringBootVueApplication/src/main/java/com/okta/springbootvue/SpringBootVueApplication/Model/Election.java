package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model;

import lombok.*;  

import javax.persistence.Id;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Entity;  
  
@Entity  
@Data  
@NoArgsConstructor

/**
 * Election Class -
 */
public class Election {  
      
  @Id @GeneratedValue  
  private int electionID;  
  
  private String title;
  
  private int closed = 0;
  
  private int admin1;
  private int admin2;
  private int admin3;
  private int admin4;
  private int admin5;
  private int admin6;
  
  private String choice1;
  private String choice2;
  private String choice3;
  private String choice4;
  private String choice5;
  
  private String close_date;
  
  private String close_time;
  
  private int num_candidates;
  
  private int num_votes;
  
  private String start_date;
  
  private String start_time;
      
}
