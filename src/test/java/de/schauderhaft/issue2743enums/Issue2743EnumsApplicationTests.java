package de.schauderhaft.issue2743enums;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Issue2743EnumsApplicationTests {
	@Autowired
	Persons persons;

	@Autowired
	EntityManager em;

	@Test
	void saveAndLoad() {
		Person jens = new Person();
		jens.firstName = "Jens";
		jens.lastName = "Schauder";
		jens.roles.add(Role.ADMIN);
		jens.roles.add(Role.CUSTOMER);
		jens = persons.save(jens);
		persons.flush();
		em.clear();

		Optional<Person> reloaded = persons.findById(jens.id);
	}

}
