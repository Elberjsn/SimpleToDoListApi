package dev.elberjsn.todoapi.usercase.person;

import dev.elberjsn.todoapi.usercase.person.ports.PersonRepository;

public record ExistsByEmailImpl(PersonRepository personRepository) implements ExistsByEmail{

    @Override
    public boolean execute(String email) {
        return personRepository.existsByEmail(email);
    }
}
