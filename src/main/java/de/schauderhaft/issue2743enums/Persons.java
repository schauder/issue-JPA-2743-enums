package de.schauderhaft.issue2743enums;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Persons extends JpaRepository<Person, Long> {
}
