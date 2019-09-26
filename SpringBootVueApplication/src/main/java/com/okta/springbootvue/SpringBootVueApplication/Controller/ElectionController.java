package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;

@RestController
public class ElectionController {

  private final ElectionRepository repository;

  ElectionController(ElectionRepository repository) {
    this.repository = repository;
  }

  //Get all elections
  @GetMapping("/elections")
  List<Election> all() {
    return repository.findAll();
  }

  //Modify Existing Election
  @PutMapping("/elections/modify/{electionId}")
  Election replaceElection(@RequestBody Election newElection, @PathVariable Long electionId) {

	return repository.findById(electionId)
		.map(election -> {
		   election.setTitle(newElection.getTitle());
		   election.setClosed(newElection.getClosed());
		   election.setNumVotes(newElection.getNumVotes());
		   election.setNumCandidates(newElection.getNumCandidates());
		   election.setCloseTime(newElection.getCloseTime());
		   election.setCloseDate(newElection.getCloseDate());
		   election.setAdmin1(newElection.getAdmin1());
		   election.setAdmin2(newElection.getAdmin2());
		   election.setAdmin3(newElection.getAdmin3());
		   election.setAdmin4(newElection.getAdmin4());
		   election.setAdmin5(newElection.getAdmin5());
		   election.setAdmin6(newElection.getAdmin6());
		   return repository.save(election);
	   })
	   .orElseGet(() -> {
	      newElection.setElectionId(electionId);
	      return repository.save(newElection);
	   });
 }

  //Get one election
 @GetMapping("/elections/{electionId}")
 Election one(@PathVariable Long electionId) {

   return repository.findById(electionId)
     .orElseThrow(() -> new ElectionNotFoundException(electionId));
 }
    
  //Add New Election
  @PostMapping("/elections/addElection")
  Election newElection(@RequestBody Election newElection) {
	  return repository.save(newElection);
  }

  //Remove one election
  @DeleteMapping("/elections/remove/{electionId}")
  void deleteElection(@PathVariable Long electionId) {
    repository.deleteById(electionId);
  }
}