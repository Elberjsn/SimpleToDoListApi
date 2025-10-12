package dev.elberjsn.todoapi.usercase.tasksharing.ports;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.usercase.tasksharing.dto.RequestTaskSharing;

import java.util.Optional;

public interface TaskSharingRepository {
    TaskSharing save(TaskSharing taskSharing);

    void updateTaskSharing(Long id,RequestTaskSharing taskSharing);
    void deleteTaskSharingByTaskAndPerson(RequestTaskSharing taskSharing);

    Optional<TaskSharing> existsTaskSharingById(Long id);

    Optional<Task> findTaskEntitiesByIdAndPersonId(Long idTask, Long idPerson);
}
