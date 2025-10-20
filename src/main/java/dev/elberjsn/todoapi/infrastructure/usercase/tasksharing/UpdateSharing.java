package dev.elberjsn.todoapi.infrastructure.usercase.tasksharing;

import dev.elberjsn.todoapi.infrastructure.usercase.tasksharing.dto.RequestTaskSharing;

public interface UpdateSharing {
    public void execute(Long id, RequestTaskSharing requestTaskSharing);
}
