package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;

import java.util.Optional;

public interface FindPersonByEmail {
    public Optional<Person> execute(String email);
}
