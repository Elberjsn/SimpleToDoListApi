package dev.elberjsn.todoapi.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.usercase.tasksharing.dto.RequestTaskSharing;
import dev.elberjsn.todoapi.usercase.tasksharing.ports.TaskSharingRepository;

import java.util.Optional;

public record FindTaskSharingByPersonIdAndTaskIdImpl(TaskSharingRepository taskSharingRepository) implements FindTaskSharingByPersonIdAndTaskId {
    @Override
    public Optional<TaskSharing> execute(Long idPerson, Long idTask) {
        return taskSharingRepository.findTaskSharingByPersonIdAndTaskId(new RequestTaskSharing(idTask, idPerson, 0));
    }
}
