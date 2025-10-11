package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.usercase.task.dto.RequestTask;

public interface UpdateTask {
    public void execute(Long idTask, RequestTask task);
}
