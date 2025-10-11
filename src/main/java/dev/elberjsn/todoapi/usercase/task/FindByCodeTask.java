package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface FindByCodeTask {
    public Task execute(String code);
}
