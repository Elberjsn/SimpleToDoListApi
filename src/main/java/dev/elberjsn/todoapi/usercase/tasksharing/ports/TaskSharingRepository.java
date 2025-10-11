package dev.elberjsn.todoapi.usercase.tasksharing.ports;

import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.usercase.tasksharing.dto.RequestTaskSharing;

import java.util.Optional;

public interface TaskSharingRepository {
    TaskSharing save(RequestTaskSharing taskSharing);

    void updateTaskSharing(Long id,RequestTaskSharing taskSharing);
    Optional<TaskSharing> findTaskSharingByPersonIdAndTaskId(RequestTaskSharing taskSharing);
    void deleteTaskSharingByTaskAndPerson(RequestTaskSharing taskSharing);

    Optional<TaskSharing> existsTaskSharingById(Long id);

}
