package dev.elberjsn.todoapi.infrastructure.repositories.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.infrastructure.repositories.person.entities.PersonEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.person.mapper.PersonEntityMapper;
import dev.elberjsn.todoapi.infrastructure.security.BCryptPasswordEncoder;
import dev.elberjsn.todoapi.usercase.person.ports.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final JpaPersonRepository jpaPersonRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PersonRepositoryImpl(JpaPersonRepository jpaPersonRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jpaPersonRepository = jpaPersonRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Person save(Person person) {
        PersonEntity entity = PersonEntityMapper.toEntity(person);
        PersonEntity save = jpaPersonRepository.save(entity);
        return PersonEntityMapper.toDomain(save);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(PersonEntityMapper.toDomain(
                jpaPersonRepository.findById(id).orElse(null)
        ));
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return Optional.ofNullable(PersonEntityMapper.toDomain(
                jpaPersonRepository.findByEmail((email)).orElse(null)
        ));
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaPersonRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaPersonRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        jpaPersonRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Person newPerson) {
        if(!existsById(id)){
            throw new BusinessException("Id Person not found");
        }
        if(!existsByEmail(newPerson.email())){
            throw new BusinessException("Email Person not found");
        }
        Person personToUpdate = new Person(id, newPerson.name(), newPerson.surname(), newPerson.email(), newPerson.password());
        jpaPersonRepository.save(PersonEntityMapper.toEntity(personToUpdate));
    }

    @Override
    public boolean login(String email, String password) {
        Optional<PersonEntity> person = jpaPersonRepository.findByEmail(email);
        if (person.isEmpty()){
            throw new BusinessException("Email not found");
        }
        if (bCryptPasswordEncoder.matches(password, person.get().getPassword())){
            throw new BusinessException("Password not match");
        }
        return true;
    }
}
