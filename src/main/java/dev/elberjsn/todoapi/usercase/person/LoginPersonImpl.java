package dev.elberjsn.todoapi.usercase.person;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.usercase.person.ports.PasswordEncoder;
import dev.elberjsn.todoapi.usercase.person.ports.PersonRepository;

public record LoginPersonImpl(PersonRepository personRepository, PasswordEncoder passwordEncoder) implements LoginPerson {

    @Override
    public boolean execute(String email, String password) {
        Person person = personRepository.findByEmail(email).orElseThrow();
       if (person.id() == null){
           throw new BusinessException("Email not found");
       }
       if (passwordEncoder.matches(password, person.password())){
            throw new BusinessException("Password not match");
       }
       return personRepository.login(email, password);
    }
}
