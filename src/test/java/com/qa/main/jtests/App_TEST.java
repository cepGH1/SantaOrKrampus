package com.qa.main.jtests;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
@SpringBootTest
@ActiveProfiles("test3")//runs these tests on the h2 in memory database
public class App_TEST {
	@Test
	public void contextLoads() {
	}
}



