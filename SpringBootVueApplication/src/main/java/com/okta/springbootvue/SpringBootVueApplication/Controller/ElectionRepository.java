package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller; 

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;  
  
@RepositoryRestResource(collectionResourceRel = "elections", path = "election")
interface ElectionRepository extends JpaRepository<Election, Long> {}
