package dev.elberjsn.todoapi.core.usercase.services.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.usercase.repositories.person.FindByEmailPersonImpl;

public class FindByEmailPerson implements FindByEmailPersonImpl {

    @Override
    public Person execute(String email) {
        return null;
    }
}
