INSERT INTO persons (id, username, first_name, last_name, email) VALUES (1, 'otto', 'Otto', 'Vodvarka', 'vodvarka@test.com');
INSERT INTO persons (id, username, first_name, last_name, email) VALUES (2, 'doe', 'John', 'Doe', 'john.doe@test.com');

INSERT INTO person_role (person_id, role) VALUES (1, 'ADMIN');
INSERT INTO person_role (person_id, role) VALUES (1, 'CUSTOMER');
INSERT INTO person_role (person_id, role) VALUES (2, 'ADMIN');
INSERT INTO person_role (person_id, role) VALUES (2, 'CUSTOMER');