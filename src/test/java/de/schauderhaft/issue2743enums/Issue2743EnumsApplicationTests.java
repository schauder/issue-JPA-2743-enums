package de.schauderhaft.issue2743enums;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Issue2743EnumsApplicationTests {
	@Autowired
	Persons persons;

	@Test
	void contextLoads() {
	}

}
