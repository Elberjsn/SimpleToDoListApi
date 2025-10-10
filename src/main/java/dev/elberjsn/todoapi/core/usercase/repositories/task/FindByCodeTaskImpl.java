package dev.elberjsn.todoapi.core.usercase.repositories.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface FindByCodeTaskImpl {
    public Task execute(String code);
}
