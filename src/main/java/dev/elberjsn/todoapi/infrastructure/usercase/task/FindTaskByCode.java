package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface FindTaskByCode {
    public Task execute(String id);
}
