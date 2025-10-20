package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.List;
import java.util.Optional;

public interface FindTaskByPersonId {
    public List<Task> execute(Long idPerson);
}
