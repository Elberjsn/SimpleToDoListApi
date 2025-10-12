package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.Optional;

public interface ExistsTaskByCode {
    public Optional<Task> execute(String code);
}
