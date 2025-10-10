package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface FindByCodeTaskImpl {
    public Task execute(String code);
}
