package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.Optional;

public interface FindTaskByPersonId {
    public Optional<Task> execute(Long idPerson);
}
