package dev.elberjsn.todoapi.usercase.person.dto;



public record PersonRequest(String name, String surname, String email, String password) {
}