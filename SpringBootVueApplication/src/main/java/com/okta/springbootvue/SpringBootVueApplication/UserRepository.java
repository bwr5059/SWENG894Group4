package src.main.java.com.okta.springbootvue.SpringBootVueApplication; 

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
interface UserRepository extends JpaRepository<User, Long> {}

