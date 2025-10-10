package dev.elberjsn.todoapi.core.usercase.repositories.tasksharing;

import dev.elberjsn.todoapi.core.domain.TaskSharing;

public interface UpdateSharingImpl {
    public void execute(Long id, TaskSharing taskSharing);
}
