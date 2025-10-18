package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface FindTaskByCode {
    public Task execute(String id);
}
