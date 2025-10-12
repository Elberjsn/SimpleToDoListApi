package dev.elberjsn.todoapi.infrastructure.repositories.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.infrastructure.repositories.person.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
