package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.infrastructure.usercase.task.dto.RequestTask;

public interface CreateTask {
    public Task execute(RequestTask task);
}
