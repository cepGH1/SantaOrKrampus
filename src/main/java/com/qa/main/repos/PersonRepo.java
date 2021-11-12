package com.qa.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.main.domain.Person;

public interface PersonRepo  extends JpaRepository<Person, Integer> {

}
