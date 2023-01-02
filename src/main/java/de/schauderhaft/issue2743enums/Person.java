package de.schauderhaft.issue2743enums;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Collection;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private String firstName;

	private String lastName;

	private String email;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Collection<Role> roles;

}
