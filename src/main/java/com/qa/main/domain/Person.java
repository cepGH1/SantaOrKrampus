package com.qa.main.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Person {
private String name;
private String sweetChoice;
private boolean goodBehaviour;

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
	this.sweetChoice = sweetChoice;
	this.goodBehaviour = goodBehaviour;
}

public Person(Integer id, String name, String sweetChoice, boolean goodBehaviour ) {
	super();
	this.name = name;
	this.sweetChoice = sweetChoice;
	this.goodBehaviour = goodBehaviour;
	this.id = id;
}

//getters and setters

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSweetChoice() {
	return sweetChoice;
}

public void setSweetChoice(String sweetChoice) {
	this.sweetChoice = sweetChoice;
}

public boolean isGoodBehaviour() {
	return goodBehaviour;
}

public void setGoodBehaviour(boolean goodBehaviour) {
	this.goodBehaviour = goodBehaviour;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}




}
