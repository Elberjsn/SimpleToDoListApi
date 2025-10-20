package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;

import java.util.Optional;

public interface FindPersonById {
    public Optional<Person> execute(Long id);
}
