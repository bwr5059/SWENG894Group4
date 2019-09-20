package src.main.java.com.okta.springbootvue.SpringBootVueApplication;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

  //add one election
  /*@PostMapping("/elections")
  Election newElection(@RequestBody Election newElection) {
    return repository.save(newElection);
  }*/

  //Get one election
 @GetMapping("/elections/{electionId}")
 Election one(@PathVariable Long electionId) {

   return repository.findById(electionId)
     .orElseThrow(() -> new ElectionNotFoundException(electionId));
 }
  
  //Add one election
  @PostMapping("/elections/addElection")
  Election replaceElection(@RequestBody Election newElection) {

        return repository.save(newElection);
  }

  //Remove one election
  @DeleteMapping("/elections/remove/{electionId}")
  void deleteElection(@PathVariable Long electionId) {
    repository.deleteById(electionId);
  }
}
