package dev.elberjsn.todoapi.core.usercase.repositories.person;

import dev.elberjsn.todoapi.core.domain.Person;

public interface UpdatePersonImpl {
    public void execute(Long id, Person newPerson);
}
