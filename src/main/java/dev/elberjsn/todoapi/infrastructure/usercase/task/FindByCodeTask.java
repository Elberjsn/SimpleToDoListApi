package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface FindByCodeTask {
    public Task execute(String code);
}
