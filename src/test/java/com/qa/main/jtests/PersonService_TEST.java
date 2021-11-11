package com.qa.main.jtests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import static org.assertj.core.api.Assertions.assertThat;

import com.qa.main.repos.PersonRepo;
import com.qa.main.service.PersonService;

@SpringBootTest
@Sql(scripts = { "classpath:person.sql","classpath:persondata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test3")//runs these tests on the h2 in memory database
public class PersonService_TEST {
	@Autowired
	PersonRepo prepo;
	PersonService service = new PersonService(prepo);
	
		
	@Test
	public void constructor_TEST() {
		//PersonService service = new PersonService(prepo);
	 assert(service instanceof PersonService);
	}

	@Test
	public void getPrepo_TEST() {
		//PersonService service = new PersonService(prepo);
		assertThat(service.getPrepo() == prepo);
	}
	
	@Test
	public void setPrepo_TEST() {
		PersonRepo frepo = prepo;
		
		service.setPrepo(frepo);
		assert(service.getPrepo() == frepo);
	}
	
	
}
