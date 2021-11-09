package com.qa.main.cont;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Person;

@SpringBootTest // boots the entire context
@AutoConfigureMockMvc // creates the MockMVC object for sending our test requests
@Sql(scripts = { "classpath:person.sql","classpath:persondata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//@ActiveProfiles("test")//runs these tests on the h2 in memory database
public class personIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper; // the EXACT SAME mapper that spring uses to convert objects to and from JSON
	
	@Test
	void testCreate() throws Exception {
		Person requestBody = new Person("Rudolph", "milk tray", true);
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);

		RequestBuilder request = post("/Person/create").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON); // sets up the test request
		

		Person responseBody = new Person(2, "Rudolph", "milk tray", true);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated(); // check the status code is 201
		ResultMatcher checkBody = content().json(responseBodyAsJSON); // check the body matches the example

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody); // performs request and checks the
																				// response
	}
}
