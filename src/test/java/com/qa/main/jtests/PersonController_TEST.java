package com.qa.main.jtests;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.qa.main.rest.PersonController;
import com.qa.main.service.PersonService;
import com.qa.main.domain.Person;

//@SpringBootTest
//@ActiveProfiles("test3")//runs these tests on the h2 in memory database
public class PersonController_TEST {
	private PersonService personService;
     private PersonController personController = new PersonController(personService);
     
     @BeforeAll
     public static void setUp() throws Exception {
    	
     }
     
     @Test
     public void personControllerConstructor_TEST() {
    	 assertThat(personController instanceof PersonController);
     }
     @Test
     public void service_TEST() {
    	 assertThat(personController.getPersonService() instanceof PersonService);
     }
     
  
    
 
}
