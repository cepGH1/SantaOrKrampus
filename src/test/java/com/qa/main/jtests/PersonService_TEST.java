package com.qa.main.jtests;

import org.junit.jupiter.api.Test;

import com.qa.main.repos.PersonRepo;
import com.qa.main.service.PersonService;

public class PersonService_TEST {
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
		assert(service.getPrepo() == prepo);
	}
	
	@Test
	public void setPrepo_TEST() {
		PersonRepo frepo = prepo;
		
		service.setPrepo(frepo);
		assert(service.getPrepo() == frepo);
	}
	
	
}
