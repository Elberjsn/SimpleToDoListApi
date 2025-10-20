package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.infrastructure.usercase.person.dto.PersonRequest;

public interface UpdatePerson {
    public void execute(Long id, PersonRequest personRepository);
}
