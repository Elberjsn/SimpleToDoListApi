package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface FindTaskById {
    public Task execute(Long id);
}
