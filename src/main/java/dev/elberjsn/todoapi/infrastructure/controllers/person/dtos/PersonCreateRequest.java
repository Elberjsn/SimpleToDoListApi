package dev.elberjsn.todoapi.infrastructure.controllers.person.dtos;

public record PersonCreateRequest(
        String name, String surname, String email, String password
) {
}
