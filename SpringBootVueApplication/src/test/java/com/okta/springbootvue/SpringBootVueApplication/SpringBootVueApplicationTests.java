import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.Assert.*;

import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.*;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.*;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.SpringBootVueApplication;

import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootVueApplicationTests {
	
	public User user = new User();
	public User user2 = new User();
	public UserServiceImpl userService = new UserServiceImpl();
	public Election election = new Election();
	public Election election2 = new Election();
	public ElectionServiceImpl electionService = new ElectionServiceImpl();
	public Candidate candidate = new Candidate();
	public Candidate candidate2 = new Candidate();
	public CandidateServiceImpl candidateService = new CandidateServiceImpl();

	@Test
    public void TestSetUser() throws Exception {
    	user.setId("test");
    	user.setType("Voter");
    	user.setAge(25);
    	user.setEthnicity("European");
    	user.setGender("F");
    	user.setAddress("160 Temp Drive");
    	user.setCity("Philadelphia");
    	user.setState("PA");
    	user.setZip("12345");
    	user.setFirst_name("Han");
    	user.setLast_name("Solo");
    	user.setProfile_complete(0);
    	user.setUser_name("sw1");
    	user.setRace("White");
    	
    	user2.setId("test");
    	user2.setType("Voter");
    	user2.setAge(25);
    	user2.setEthnicity("European");
    	user2.setGender("F");
    	user2.setAddress("160 Temp Drive");
    	user2.setCity("Philadelphia");
    	user2.setState("PA");
    	user2.setZip("12345");
    	user2.setFirst_name("Han");
    	user2.setLast_name("Solo");
    	user2.setProfile_complete(0);
    	user2.setUser_name("sw1");
    	user2.setRace("White");
    	
    	assertTrue(user.equals(user2));
    	
    	assertEquals("test", user.getId());
    	assertEquals("Voter", user.getType());
    	assertEquals(25, user.getAge());
    	assertEquals("European", user.getEthnicity());
    	assertEquals("F", user.getGender());
    	assertEquals("160 Temp Drive", user.getAddress());
    	assertEquals("Philadelphia", user.getCity());
    	assertEquals("PA", user.getState());
    	assertEquals("12345", user.getZip());
    	assertEquals("Han", user.getFirst_name());
    	assertEquals("Solo", user.getLast_name());
    	assertEquals(0, user.getProfile_complete());
    	assertEquals("sw1", user.getUser_name());
    	assertEquals("White", user.getRace());
    }
	
	@Test
    public void TestSetElection() throws Exception {
    	election.setElectionID(1);
    	election.setTitle("Test");
    	election.setClosed(1);
    	election.setAdmin1(1);
    	election.setAdmin2(2);
    	election.setAdmin3(3);
    	election.setAdmin4(4);
    	election.setAdmin5(5);
    	election.setAdmin6(6);
    	election.setChoice1("one");
    	election.setChoice2("two");
    	election.setChoice3("three");
    	election.setChoice4("four");
    	election.setChoice5("five");
    	election.setClose_date("10-20-2019");
    	election.setClose_time("5");
    	election.setNum_candidates(3);
    	election.setNum_votes(1);
    	election.setStart_date("9-29-2019");
    	election.setStart_time("8");
    	election.setDescription("Description");
    	
    	election2.setElectionID(1);
    	election2.setTitle("Test");
    	election2.setClosed(1);
    	election2.setAdmin1(1);
    	election2.setAdmin2(2);
    	election2.setAdmin3(3);
    	election2.setAdmin4(4);
    	election2.setAdmin5(5);
    	election2.setAdmin6(6);
    	election2.setChoice1("one");
    	election2.setChoice2("two");
    	election2.setChoice3("three");
    	election2.setChoice4("four");
    	election2.setChoice5("five");
    	election2.setClose_date("10-20-2019");
    	election2.setClose_time("5");
    	election2.setNum_candidates(3);
    	election2.setNum_votes(1);
    	election2.setStart_date("9-29-2019");
    	election2.setStart_time("8");
    	election2.setDescription("Description");
    	
    	assertTrue(election.equals(election2));
    	
    	assertEquals(1, election.getElectionID());
    	assertEquals("Test", election.getTitle());
    	assertEquals(1, election.getClosed());
    	assertEquals(1, election.getAdmin1());
    	assertEquals(2, election.getAdmin2());
    	assertEquals(3, election.getAdmin3());
    	assertEquals(4, election.getAdmin4());
    	assertEquals(5, election.getAdmin5());
    	assertEquals(6, election.getAdmin6());
    	assertEquals("one", election.getChoice1());
    	assertEquals("two", election.getChoice2());
    	assertEquals("three", election.getChoice3());
    	assertEquals("four", election.getChoice4());
    	assertEquals("five", election.getChoice5());
    	assertEquals("10-20-2019", election.getClose_date());
    	assertEquals("5", election.getClose_time());
    	assertEquals(3, election.getNum_candidates());
    	assertEquals(1, election.getNum_votes());
    	assertEquals("9-29-2019", election.getStart_date());
    	assertEquals("8", election.getStart_time());
    	assertEquals("Description", election.getDescription());
    }
    
    @Test
    public void TestSetCandidate() throws Exception {
    	candidate.setCanID("test");
    	candidate.setUserID("userTest");
    	candidate.setFirst_name("First");
    	candidate.setLast_name("Last");
    	candidate.setEmail("email");
    	candidate.setElectionID(1);
    	candidate.setAbout("about");
    	candidate.setEducation("education");
    	candidate.setEmployment("employment");
    	candidate.setExperience("experience");
    	candidate.setContact("contact");
    	
    	candidate2.setCanID("test");
    	candidate2.setUserID("userTest");
    	candidate2.setFirst_name("First");
    	candidate2.setLast_name("Last");
    	candidate2.setEmail("email");
    	candidate2.setElectionID(1);
    	candidate2.setAbout("about");
    	candidate2.setEducation("education");
    	candidate2.setEmployment("employment");
    	candidate2.setExperience("experience");
    	candidate2.setContact("contact");
    	
    	assertTrue(candidate.equals(candidate2));
    	
    	assertEquals("test", candidate.getCanID());
    	assertEquals("userTest", candidate.getUserID());
    	assertEquals("First", candidate.getFirst_name());
    	assertEquals("Last", candidate.getLast_name());
    	assertEquals("email", candidate.getEmail());
    	assertEquals(1, candidate.getElectionID());
    	assertEquals("about", candidate.getAbout());
    	assertEquals("education", candidate.getEducation());
    	assertEquals("employment", candidate.getEmployment());
    	assertEquals("experience", candidate.getExperience());
    	assertEquals("contact", candidate.getContact());
    }
    
    @Test
    public void TestUserServices() throws Exception {
    	//Mockito.when(userService.findAllUsers()).thenReturn("Success");
    	
    }
    
    @Test
    public void CreateElection() throws Exception {
    	
    }

}
