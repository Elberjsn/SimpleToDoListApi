package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.infrastructure.usercase.task.dto.RequestTask;

public interface UpdateTask {
    public void execute(Long idTask, RequestTask task);
}
