package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.Optional;

public interface FindTaskByPersonIdImpl {
    public Optional<Task> execute(Long idPerson);
}
