package dev.elberjsn.todoapi.core.usercase.services.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.usercase.repositories.person.CreatePersonImpl;

import java.util.Random;

public class CreatePerson implements CreatePersonImpl {

    @Override
    public Person execute(Person person) {
        return  new Person(new Random().nextLong(), person.name(), person.surname(), person.email(), person.password());
    }
}
