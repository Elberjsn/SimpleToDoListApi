package dev.elberjsn.todoapi.infrastructure.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.infrastructure.usercase.person.ports.PersonRepository;

import java.util.Optional;

public class FindPersonByIdImpl implements FindPersonById{
    private final PersonRepository personRepository;
    public FindPersonByIdImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public Optional<Person> execute(Long id) {
        return personRepository.findById(id);
    }
}
