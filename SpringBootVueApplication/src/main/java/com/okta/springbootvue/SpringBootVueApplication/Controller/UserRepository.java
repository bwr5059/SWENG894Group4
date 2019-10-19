package src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller; 

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;  
  
@RepositoryRestResource(collectionResourceRel = "users", path = "user")
interface UserRepository extends JpaRepository<User, Long> {}
