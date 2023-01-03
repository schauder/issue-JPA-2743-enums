package de.schauderhaft.issue2743enums;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface Persons extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p from Person AS p JOIN p.roles role" +
            " WHERE role IN (:visibleRoles) AND " +
            "(:filterByRole IS NULL OR role IN (:filterByRole))")
    Page<Person> searchPersons(@Param("visibleRoles") Set<Role> visibleRoles,
                               @Param("filterByRole") Set<Role> filterByRole,
                               Pageable pageable);

}
