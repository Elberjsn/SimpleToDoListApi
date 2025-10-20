package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.infrastructure.usercase.person.ports.PersonRepository;

import java.util.Optional;

public class FindPersonByEmailImpl implements FindPersonByEmail{

    private final PersonRepository personRepository;

    public FindPersonByEmailImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> execute(String email) {
        return personRepository.findByEmail(email);
    }
}
