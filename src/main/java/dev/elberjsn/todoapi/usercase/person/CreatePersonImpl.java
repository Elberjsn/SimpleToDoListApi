package dev.elberjsn.todoapi.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.usercase.person.dto.PersonRequest;
import dev.elberjsn.todoapi.usercase.person.ports.PasswordEncoder;
import dev.elberjsn.todoapi.usercase.person.ports.PersonRepository;

public record CreatePersonImpl(PersonRepository personRepository, PasswordEncoder passwordEncoder) implements CreatePerson {

    @Override
    public Person execute(PersonRequest person) {
        validate(person);

        if (personRepository.existsByEmail(person.email())) {
            throw new BusinessException("Email already exists");
        }
        return personRepository.save(new Person(null, person.name(), person.surname(), person.email(), passwordEncoder.encode(person.password())));


    }

    private void validate(PersonRequest person) {
        if (person.name() == null || person.name().trim().isEmpty()) {
            throw new BusinessException("Name is required");
        }

        if (person.surname() == null || person.surname().trim().isEmpty()) {
            throw new BusinessException("Surname is required");
        }

        if (person.email() == null || person.email().trim().isEmpty()) {
            throw new BusinessException("Surname is required");
        }

        if (person.password() == null || person.password().trim().isEmpty()) {
            throw new BusinessException("Surname is required");
        }
    }

}
