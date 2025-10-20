package dev.elberjsn.todoapi.infrastructure.usercase.person;

public interface LoginPerson {
    public boolean execute(String email, String password);
}
