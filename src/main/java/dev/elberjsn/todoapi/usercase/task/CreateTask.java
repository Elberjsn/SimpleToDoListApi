package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.usercase.task.dto.RequestTask;

public interface CreateTask {
    public Task execute(RequestTask task);
}
