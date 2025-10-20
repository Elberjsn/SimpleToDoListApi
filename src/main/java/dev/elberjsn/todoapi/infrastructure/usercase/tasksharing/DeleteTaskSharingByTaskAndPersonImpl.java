package dev.elberjsn.todoapi.infrastructure.usercase.tasksharing;

import dev.elberjsn.todoapi.infrastructure.usercase.tasksharing.dto.RequestTaskSharing;
import dev.elberjsn.todoapi.infrastructure.usercase.tasksharing.ports.TaskSharingRepository;

public record DeleteTaskSharingByTaskAndPersonImpl(TaskSharingRepository taskSharingRepository) implements DeleteTaskSharingByTaskAndPerson {
    @Override
    public void execute(Long idTask, Long idPerson) {
        taskSharingRepository.deleteTaskSharingByTaskAndPerson(new RequestTaskSharing(idTask, idPerson, 0));
    }
}
