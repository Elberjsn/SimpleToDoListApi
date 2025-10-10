package dev.elberjsn.todoapi.usercase.person.ports;

public interface PasswordEncoder {
    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
