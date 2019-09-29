package src.test.java.com.okta.springbootvue.SpringBootVueApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootVueApplicationTests {

	@Test
	public void testUserSetName() {
		String name = "TEST";
		
		User user = new User();  
        user.setFirstName(name);  
        
        assertEquals(name,user.getFirstName());
        
	}

}
