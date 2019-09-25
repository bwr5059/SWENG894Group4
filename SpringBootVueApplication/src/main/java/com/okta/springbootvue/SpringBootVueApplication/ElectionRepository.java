package src.main.java.com.okta.springbootvue.SpringBootVueApplication; 

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource(collectionResourceRel = "elections", path = "election")
interface ElectionRepository extends JpaRepository<Election, Long> {}
