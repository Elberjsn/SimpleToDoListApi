package dev.elberjsn.todoapi.usercase.person;

import dev.elberjsn.todoapi.usercase.person.dto.PersonRequest;

public interface UpdatePerson {
    public void execute(Long id, PersonRequest personRepository);
}
