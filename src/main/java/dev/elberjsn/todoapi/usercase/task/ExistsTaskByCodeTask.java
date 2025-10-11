package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.Optional;

public interface ExistsTaskByCodeTask {
    public Optional<Task> execute(String code);
}
