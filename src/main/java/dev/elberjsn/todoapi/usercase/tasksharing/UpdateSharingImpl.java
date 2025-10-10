package dev.elberjsn.todoapi.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.TaskSharing;

public interface UpdateSharingImpl {
    public void execute(Long id, TaskSharing taskSharing);
}
