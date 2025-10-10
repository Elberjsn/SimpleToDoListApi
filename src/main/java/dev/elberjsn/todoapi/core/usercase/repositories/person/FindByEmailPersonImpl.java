package dev.elberjsn.todoapi.core.usercase.repositories.person;

import dev.elberjsn.todoapi.core.domain.Person;

public interface FindByEmailPersonImpl {
    public Person execute(String email);
}
