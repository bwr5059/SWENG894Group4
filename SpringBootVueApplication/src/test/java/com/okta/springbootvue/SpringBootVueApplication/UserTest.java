package src.test.java.com.okta.springbootvue.SpringBootVueApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepo;
 
    @Test
    public void findById_thenReturnUser() {
        // given
        User one = new User();
        entityManager.persist(user);
        entityManager.flush();
     
        // when
        User found = userRepo.findById(one.getId());
     
        // then
        assertThat(found.getId())
          .isEqualTo(one.getId());
    }
 
}
