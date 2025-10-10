package dev.elberjsn.todoapi.core.usercase.services.person;

import dev.elberjsn.todoapi.core.usercase.repositories.person.LoginPersonImpl;

import java.util.Random;

public class LoginPerson implements LoginPersonImpl {

@Override
    public boolean execute(String email, String password) {
        return new Random().nextBoolean();
    }
}
