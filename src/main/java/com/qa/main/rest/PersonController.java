package com.qa.main.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.main.domain.Person;
import com.qa.main.service.PersonService;

@RestController
@RequestMapping("/Person")
public class PersonController{

	private PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}
	
	//post to person table a new person
		@PostMapping("/create")
		public ResponseEntity<Person> createPerson(@RequestBody Person newPerson) {
			Person responsebody  = this.service.createPerson(newPerson);
			
			return new ResponseEntity<Person>(responsebody, HttpStatus.CREATED);
		}
		
		//replace a person in the person table
		@PutMapping("replace/{myIndex}")
		public ResponseEntity<Person> replaceDeer(@PathVariable Integer myIndex, @RequestBody Person newPerson){
			System.out.println("Replacing Person with id " + myIndex + " with " + newPerson);
			
			Person inThereNow = this.service.replacePerson(myIndex, newPerson);
			return new ResponseEntity<Person>(inThereNow, HttpStatus.ACCEPTED);
			
		}
		
		//retrieve a single person from the database
		@GetMapping("/get/{myIndex}")
		public Person getPerson(@PathVariable Integer myIndex){
			Person myPerson = this.service.getPerson(myIndex);
			return myPerson;
		}
		
		//show the whole table contents
		@GetMapping("/getThemAll")
		public ResponseEntity<List<Person>> getThemAll(){
			
			return ResponseEntity.ok(this.service.getPeople());
		}
		
		
		
		//remove a person from the person table
		@DeleteMapping("/remove/{myIndex}")
		public ResponseEntity<Person> removePerson(@PathVariable Integer myIndex){
			System.out.println("Removing person with id " + myIndex);
			
			boolean worked = this.service.removePerson(myIndex);
			if (worked) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		
		
}
		@GetMapping("/getGood")
		public ResponseEntity<List<Person>> getGoodPeople(){
			return ResponseEntity.ok(this.service.getGoodPeople());
		}
		
		@GetMapping("/getBad")
		public ResponseEntity<List<Person>> getBadPeople(){
			return ResponseEntity.ok(this.service.getBadPeople());
		}
		
		
}
