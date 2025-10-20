package dev.elberjsn.todoapi.infrastructure.usercase.person.dto;



public record PersonRequest(String name, String surname, String email, String password) {
}