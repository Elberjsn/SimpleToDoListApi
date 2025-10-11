package dev.elberjsn.todoapi.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.usercase.tasksharing.dto.RequestTaskSharing;
import dev.elberjsn.todoapi.usercase.tasksharing.ports.TaskSharingRepository;

public record UpdateSharingImpl(TaskSharingRepository taskSharingRepository) implements UpdateSharing {
    @Override
    public void execute(Long id, RequestTaskSharing requestTaskSharing) {
        var ts = taskSharingRepository.existsTaskSharingById(id);
        if (ts.isEmpty()){
            throw new BusinessException("Sharing not found");
        }

        taskSharingRepository.updateTaskSharing(id,requestTaskSharing);


    }
}
