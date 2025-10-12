package dev.elberjsn.todoapi.infrastructure.security;

import dev.elberjsn.todoapi.usercase.person.ports.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

    private final org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder;

    public BCryptPasswordEncoder() {
        this.encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }

    @Override
    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}