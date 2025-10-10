package dev.elberjsn.todoapi.core.domain;

public record Person(
        Long id, String name, String surname,String email, String password, Boolean particular
) {
}
