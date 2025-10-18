package dev.elberjsn.todoapi.infrastructure.repositories.person.mapper;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.infrastructure.controllers.person.dtos.PersonCreateRequest;
import dev.elberjsn.todoapi.infrastructure.controllers.person.dtos.PersonRequestDto;
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

    public static Person toDomainDTO(PersonCreateRequest person){
        if (person == null) return null;

        return Person.builder(
               null, person.name(), person.surname(), person.email(), person.password()
        );
    }

    public static PersonRequestDto toDTO(Person person){
        if (person == null) return null;
        return new PersonRequestDto(person.id(), person.name(), person.surname(), person.email());
    }
}
