package dev.elberjsn.todoapi.infrastructure.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.TaskSharing;

public interface CreateSharing {
    public TaskSharing execute(TaskSharing taskSharing);
}
