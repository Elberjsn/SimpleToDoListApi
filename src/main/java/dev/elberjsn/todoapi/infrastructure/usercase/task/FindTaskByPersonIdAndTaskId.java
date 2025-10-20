package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.Optional;

public interface FindTaskByPersonIdAndTaskId {
    Optional<Task> execute(Long idPerson, Long idTask);
}
