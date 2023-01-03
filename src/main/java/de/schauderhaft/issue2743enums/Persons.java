package de.schauderhaft.issue2743enums;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface Persons extends JpaRepository<Person, Long> {

    String QUERY = "SELECT DISTINCT p from Person AS p JOIN p.roles role" +
            " WHERE role IN (?1) AND " +
            "(?2 IS NULL OR role IN (?2))";

    @Query(QUERY)
    Page<Person> searchPersons(@Param("visibleRoles") Set<Role> visibleRoles,
                               @Param("filterByRole") Set<Role> filterByRole,
                               Pageable pageable);

}
