package com.qa.main.service;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.main.domain.Person;
import com.qa.main.repos.PersonRepo;

@Service
public class PersonService {

	PersonRepo prepo;
	
	//constructor
		public PersonService(PersonRepo prepo) {
		super();
		this.prepo = prepo;
	}
		
	//getters and setters
		public PersonRepo getPrepo() {
			return prepo;
		}



		public void setDrepo(PersonRepo prepo) {
			this.prepo = prepo;
		}
		
	//makes an entry in the table person	
		public Person createPerson(Person newPerson) {
			
			return this.prepo.save(newPerson);
		}
		
		// return all entries of the table person
		public List<Person> getPeople() {
			
			return this.prepo.findAll();
		}
		
		//gets a particular person from the person table
		public Person getPerson(Integer id) {
			Optional<Person> personOptional = this.prepo.findById(id);

			if (personOptional.isPresent()) {
				Person person = personOptional.get();
				return person;
			} else {
				throw new EntityNotFoundException("No person found with id: " + id);
			}
		}
		
		//modify an entry in the person table of the 
		public Person replacePerson(Integer id, Person newPerson) {
			
			Person existing = this.getPerson(id);

			existing.setSweet(newPerson.getSweet());
			existing.setGood(newPerson.isGood());
			existing.setName(newPerson.getName());

			return this.prepo.save(existing);
		}
		
		//remove one person using their id
		public boolean removePerson(Integer id) {
			
			this.prepo.deleteById(id);
			return !this.prepo.existsById(id);
		}
		
		
}
