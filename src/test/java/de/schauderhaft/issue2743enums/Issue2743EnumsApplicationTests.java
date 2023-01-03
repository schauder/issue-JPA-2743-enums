package de.schauderhaft.issue2743enums;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

@SpringBootTest
class Issue2743EnumsApplicationTests {

	@Autowired
	Persons persons;

	@Autowired
	EntityManager em;

	@Test
	void testSpringData() {
		Page<Person> page = persons.searchPersons(Set.of(Role.CUSTOMER), Set.of(Role.CUSTOMER), Pageable.unpaged());
		page.getContent();
	}

	@Test
	void testJPA() {
		Query query = em.createQuery(Persons.QUERY, Person.class);
		query.setParameter(1, Set.of(Role.CUSTOMER));
		query.setParameter(2, Set.of(Role.CUSTOMER));
		query.getResultList();
	}

}
