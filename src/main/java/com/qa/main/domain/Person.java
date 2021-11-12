package com.qa.main.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Person {
private String name;
private String sweet;
private boolean good;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

//constructors

public Person() {
	super();
}

public Person(String name, String sweetChoice, boolean goodBehaviour) {
	super();
	this.name = name;
	this.sweet = sweetChoice;
	this.good = goodBehaviour;
}

public Person(Integer id, String name, String sweet, boolean good ) {
	super();
	this.name = name;
	this.sweet = sweet;
	this.good = good;
	this.id = id;
}

//getters and setters

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSweet() {
	return sweet;
}

public void setSweet(String sweetChoice) {
	this.sweet = sweetChoice;
}

public boolean isGood() {
	return good;
}

public void setGood(boolean goodBehaviour) {
	this.good = goodBehaviour;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}




}
