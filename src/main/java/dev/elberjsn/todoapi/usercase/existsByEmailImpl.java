package dev.elberjsn.todoapi.usercase;

import dev.elberjsn.todoapi.usercase.person.ExistsByEmail;
import dev.elberjsn.todoapi.usercase.person.ports.PersonRepository;

public class existsByEmailImpl implements ExistsByEmail {

    final PersonRepository personRepository;
    public existsByEmailImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public boolean execute(String email) {
        return this.personRepository.existsByEmail(email);
    }


}
