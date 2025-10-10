package dev.elberjsn.todoapi.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.usercase.person.ports.PersonRepository;

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
