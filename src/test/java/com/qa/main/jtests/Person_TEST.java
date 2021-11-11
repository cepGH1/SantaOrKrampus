package com.qa.main.jtests;

import org.junit.jupiter.api.Test;


import com.qa.main.domain.Person;



public class Person_TEST {

	@Test
	public void constructor_TEST() {
		Person person = new Person();
		assert(person instanceof Person);
		
		 
	}
	
	@Test
	public void constructor_TEST2(){
		Person person = new Person("clare", "chocolate", true);
		assert(person instanceof Person);
	}
	
	@Test
	public void constructor_TEST3() {
		Person person = new Person(1, "clare", "frys", true);
		assert(person instanceof Person);
	}
	
	
	@Test
	public void getName_TEST() {
		Person person = new Person("clare", "chocolate", true);
		String name = "clare";
		assert(person.getName() == name);
		
	}
	
	@Test
	public void getSweet_TEST3() {
		Person person = new Person("clare", "chocolate", true);
		String sweet = "chocolate";
		assert(person.getSweet() == sweet);
		
	}
	
	@Test
	public void isGood_TEST3() {
		Person person = new Person("clare", "chocolate", true);
		boolean good = true;
		assert(person.isGood() == good);
		
	}
	
	@Test
	public void setGood_TEST() {
		Person person = new Person("clare", "chocolate", false);
		person.setGood(true);
		assert(person.isGood() == true);
	}
	
	@Test
	public void setName_TEST() {
		Person person = new Person("clare", "frys", true);
		person.setName("fred");
		assert(person.getName() == "fred");
	}
	
	@Test
	public void setSweet_TEST() {
		Person person = new Person("clare", "frys", true);
		person.setSweet("haribo");
		assert(person.getSweet() == "haribo");
		
	}
	
	@Test
	public void setId_TEST() {
		Person person = new Person(1, "clare", "frys", true);
		person.setId(5);
		assert(person.getId() == 5);
	}
	
	@Test
	public void getId_TEST() {
		Person person = new Person(1, "clare", "frys", true);
		assert(person.getId() == 1);
		
	}
}
