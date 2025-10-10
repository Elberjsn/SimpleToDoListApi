package dev.elberjsn.todoapi.core.usercase.services.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.usercase.repositories.task.FindByCodeTaskImpl;

public class FindByCodeTask implements FindByCodeTaskImpl {
    @Override
    public Task execute(String code) {
        return null;
    }
}
