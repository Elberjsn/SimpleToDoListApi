package dev.elberjsn.todoapi.infrastructure.repositories.person.mapper;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.infrastructure.repositories.person.entities.PersonEntity;

public class PersonEntityMapper {

    public static Person toDomain(PersonEntity personEntity) {
        if (personEntity == null) return null;

        return Person.builder(
                personEntity.getId(), personEntity.getName(), personEntity.getSurname(), personEntity.getEmail(), personEntity.getPassword()
        );
    }

    public static PersonEntity toEntity(Person domain) {

        if (domain == null) return null;
        return new PersonEntity(
                domain.id(),
                domain.name(),
                domain.surname(),
                domain.email(),
                domain.password(),
                null,
                null
        );
    }
}
