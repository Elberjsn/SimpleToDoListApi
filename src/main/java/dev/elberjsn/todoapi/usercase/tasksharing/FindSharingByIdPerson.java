package dev.elberjsn.todoapi.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.Optional;

public interface FindSharingByIdPerson {
    public Optional<Task> execute(Long idPerson);
}
