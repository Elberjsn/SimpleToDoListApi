package dev.elberjsn.todoapi.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.TaskSharing;

import java.util.Optional;

public interface FindTaskSharingByPersonIdAndTaskId {
    public Optional<TaskSharing> execute(Long idPerson, Long idTask);
}
