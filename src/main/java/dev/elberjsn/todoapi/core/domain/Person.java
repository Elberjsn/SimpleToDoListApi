package dev.elberjsn.todoapi.core.domain;

public record Person(
        Long id, String name, String surname,String email, String password
) {
    public static Person builder(Long id, String name, String surname, String email, String password) {
        return new Person(id, name, surname, email, password);
    }
}
