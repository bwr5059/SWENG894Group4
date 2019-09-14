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

  // Aggregate root
  @GetMapping("/elections")
  List<Election> all() {
    return repository.findAll();
  }

  @PostMapping("/elections")
  Election newElection(@RequestBody Election newElection) {
    return repository.save(newElection);
  }

  // Single item
  /*@GetMapping("/elections/{id}")
  Election one(@PathVariable Long id) {

    return repository.findById(id)
      //.orElseThrow(() -> new ElectionNotFoundException(id));
  }*/

  @PutMapping("/elections/{electionId}")
  Election replaceElection(@RequestBody Election newElection, @PathVariable Long electionId) {

    return repository.findById(electionId)
      .map(election -> {
    	  election.setTitle(newElection.getTitle());
        return repository.save(election);
      })
      .orElseGet(() -> {
        newElection.setElectionId(electionId);
        return repository.save(newElection);
      });
  }

  @DeleteMapping("/elections/{electionId}")
  void deleteElection(@PathVariable Long electionId) {
    repository.deleteById(electionId);
  }
}