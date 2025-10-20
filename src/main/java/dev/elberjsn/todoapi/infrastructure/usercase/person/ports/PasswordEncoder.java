package dev.elberjsn.todoapi.infrastructure.usercase.person.ports;

public interface PasswordEncoder {
    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
