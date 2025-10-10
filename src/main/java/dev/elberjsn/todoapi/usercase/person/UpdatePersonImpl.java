package dev.elberjsn.todoapi.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.usercase.person.dto.PersonRequest;
import dev.elberjsn.todoapi.usercase.person.ports.PersonRepository;

public record UpdatePersonImpl(PersonRepository personRepository) implements UpdatePerson{

    @Override
    public void execute(Long id, PersonRequest person) {
        if(!personRepository.existsById(id)){
            throw new BusinessException("Id Person not found");
        }
        if(!personRepository.existsByEmail(person.email())){
            throw new BusinessException("Email Person not found");
        }
        Person personToUpdate = new Person(id, person.name(), person.surname(), person.email(), person.password());
        personRepository.update(id, personToUpdate);
    }

}
