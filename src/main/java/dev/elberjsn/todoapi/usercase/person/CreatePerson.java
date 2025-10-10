package dev.elberjsn.todoapi.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.usercase.person.dto.PersonRequest;

public interface CreatePerson {
    Person execute(PersonRequest person);

}
