package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.infrastructure.usercase.person.dto.PersonRequest;

public interface CreatePerson {
    Person execute(PersonRequest person);

}
