package com.okta.springbootvue.SpringBootVueApplication.Controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.Election;
import java.util.List;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Model.User;
import src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.ElectionController;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:SpringBootVueApplication.class")
public class ElectionControllerTest {

    Election election = new Election();

    public void before() {


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

    }

    User user = new User();



    @InjectMocks
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Controller.ElectionController electionController;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.UserService userService;

    @Mock
    src.main.java.com.okta.springbootvue.SpringBootVueApplication.Service.ElectionService electionService;

    @Test
    public void listAllElections() {

        electionService.addElection(election);

        Election election2 = electionService.findElectionById(election.getElectionID());

        assertEquals(election2.getElectionID(), 1);

        List<Election> elections = electionService.findAllElections();

        assertNotNull(elections);
    }

    @Test
    public void getElection() {

        electionService.addElection(election);

        Election election2 = electionService.findElectionById(election.getElectionID());

        assertEquals(election.getElectionID(),election2.getElectionID());
    }

    @Test
    public void newElection() {

        electionService.addElection(election);

        Election election2 = electionService.findElectionById(election.getElectionID());

        assertEquals(election.getElectionID(), election2.getElectionID());
    }

    @Test
    public void modifyElection() {

        electionService.addElection(election);



        election.setElectionID(123);
        election.setTitle("Test2");

        electionService.updateElection(election);

        Election election2 = electionService.findElectionById(123);

        assertEquals(election2.getElectionID(), 123);
        assertEquals(election2.getTitle(), "Test2");
    }

    @Test
    public void deleteElection() {


        electionService.addElection(election);

        electionService.deleteElectionById(1);

        Election election2 = electionService.findElectionById(1);

        assertNull(election2);
    }

    @Ignore
    @Test
    public void associateVoter() {
    }

    @Ignore
    @Test
    public void removeVoter() {
    }

    @Ignore
    @Test
    public void validateVoter() {
    }

    @Ignore
    @Test
    public void associateCandidate() {
    }

    @Ignore
    @Test
    public void removeCandidate() {
    }

    @Ignore
    @Test
    public void validateCandidate() {
    }

    @Ignore
    @Test
    public void viewCandidates() {
    }

    @Ignore
    @Test
    public void getPolicy() {
    }

    @Ignore
    @Test
    public void createPolicy() {
    }

    @Ignore
    @Test
    public void modifyPolicy() {
    }
}