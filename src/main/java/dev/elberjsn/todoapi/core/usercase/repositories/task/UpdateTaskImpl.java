package dev.elberjsn.todoapi.core.usercase.repositories.task;

import dev.elberjsn.todoapi.core.domain.Task;

public interface UpdateTaskImpl {
    public Task execute(int idTask, Task newTask);
}
