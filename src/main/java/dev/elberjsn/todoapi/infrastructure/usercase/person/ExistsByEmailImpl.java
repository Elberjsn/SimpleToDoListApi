package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.infrastructure.usercase.person.ports.PersonRepository;

public record ExistsByEmailImpl(PersonRepository personRepository) implements ExistsByEmail{

    @Override
    public boolean execute(String email) {
        return personRepository.existsByEmail(email);
    }
}
