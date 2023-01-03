package de.schauderhaft.issue2743enums;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
class Issue2743EnumsApplicationTests {

	@Autowired
	Persons persons;

	@Autowired
	EntityManager em;

	@Test
	void test() {
		Page<Person> page = persons.searchPersons(Set.of(Role.CUSTOMER), Set.of(Role.CUSTOMER), Pageable.unpaged());
		page.getContent();
	}

}
