package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	String QUERY = "SELECT DISTINCT p from Person AS p JOIN p.roles role" +
			" WHERE role IN (?1) AND " +
			"(?2 IS NULL OR role IN (?2))";

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void runThisMultipleTimes() throws Exception {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// Do stuff...

		TypedQuery<Person> query = entityManager.createQuery(QUERY, Person.class);
		query.setParameter(1, Set.of(Role.CUSTOMER));
		query.setParameter(2, Set.of(Role.CUSTOMER));
		query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
