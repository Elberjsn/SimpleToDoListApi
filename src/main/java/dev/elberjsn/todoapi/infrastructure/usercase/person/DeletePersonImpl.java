package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.infrastructure.usercase.person.ports.PersonRepository;

public record DeletePersonImpl(PersonRepository personRepository) {

    public void execute(Long id) {
        try {
            personRepository.delete(id);
        } catch (RuntimeException e) {
            throw new BusinessException("Error deleting person", e.getCause());
        }
    }
}
