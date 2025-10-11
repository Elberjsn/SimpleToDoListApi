package dev.elberjsn.todoapi.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.usercase.tasksharing.dto.RequestTaskSharing;

public interface UpdateSharing {
    public void execute(Long id, RequestTaskSharing requestTaskSharing);
}
