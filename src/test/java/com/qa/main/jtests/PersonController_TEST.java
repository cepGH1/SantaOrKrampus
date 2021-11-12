package com.qa.main.jtests;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.qa.main.rest.PersonController;
import com.qa.main.service.PersonService;
import com.qa.main.domain.Person;

@SpringBootTest
@Sql(scripts = { "classpath:person.sql","classpath:persondata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test3")//runs these tests on the h2 in memory database
public class PersonController_TEST {
	@Autowired
	private PersonService personService;
	@Autowired
     private PersonController personController = new PersonController(personService);
     
     @BeforeAll
     public static void setUp() throws Exception {
    	
     }
     
     @Test
     public void personControllerConstructor_TEST() {
    	 assertThat(personController instanceof PersonController);
     }
     @Test
     public void service_TEST() throws Exception {
    	 assertThat(personController.getPersonService() instanceof PersonService);
     }
     
     @Test
 	public void contextLoads() throws Exception {
 		assertThat(personController.getPersonService()).isNotNull();
 	}
     
   @Test
   public void cont_TEST() throws Exception{
	   assertThat(personController).isNotNull();
   }
     
     
  @Test
  public void create_TEST() {
	  ResponseEntity<Person> response = personController.createPerson(new Person("fred", "candy", true));
	  
	 
	  int status =  response.getStatusCodeValue();
	  
	  
	  assertThat(status == 201 );
	  
  }
    
  @Test
  public void remove_TEST() {
	  ResponseEntity<Person> response = personController.createPerson(new Person("fred", "candy", true));
	  ResponseEntity<Person> removeResponse = personController.removePerson(2);
	  
	 
	  int status =  removeResponse.getStatusCodeValue();
	  
	  
	  assertThat(status == 204 );
	  
  }
  
  @Test
  public void replace_TEST() {
	  ResponseEntity<Person> response = personController.createPerson(new Person("fred", "candy", true));
	  Person inThereNow = new Person("zan", "dreamies", true);
	  Person removed = new Person(2,"fred", "candy", true);
	  ResponseEntity<Person> response2 = personController.replacePerson(2, inThereNow);
	  assertThat(response2.getBody() == removed );
  }
  
  @Test
  public void getPerson_TEST() {
	  Person response = personController.getPerson(1);
	  Person checkPerson = new Person(1, "frad", "lollipops", true);
	  assertThat(response == checkPerson);
  }
  
  @Test
  public void getThemAll_TEST() {
	  ResponseEntity<List<Person>> myList = personController.getThemAll();
	  assert(myList.getStatusCodeValue() == 200);
	  }
  
  @Test
  public void getGoodPeople_TEST() {
	  ResponseEntity<Person> response = personController.createPerson(new Person("chris", "candy", false));
	  ResponseEntity<List<Person>> myList = personController.getGoodPeople();
	  assert(myList.getStatusCodeValue() == 200);
  }
  
  @Test
  public void getBadPeople_TEST() {
	  //ResponseEntity<Person> response = personController.createPerson(new Person("chris", "candy", false));
	  ResponseEntity<List<Person>> myList = personController.getBadPeople();
	  assert(myList.getStatusCodeValue() == 200);
  }
  
   
  
}
