package dev.elberjsn.todoapi.usercase.person.ports;

import dev.elberjsn.todoapi.core.domain.Person;

import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(Long id);
    Optional<Person> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsById(Long id);
    void delete(Long id);
    void update(Long id, Person newPerson);
    boolean login(String email, String password);
}
