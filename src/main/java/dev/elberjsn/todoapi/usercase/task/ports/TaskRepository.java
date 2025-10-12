package dev.elberjsn.todoapi.usercase.task.ports;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.usercase.tasksharing.dto.RequestTaskSharing;

import java.util.Optional;

public interface TaskRepository {

    public Task save(Task task);
    public Optional<Task> findTaskById(Long id);
    public Optional<Task> findTaskByIdPerson(Long idPerson);
    public boolean existsTaskById(Long id);
    public Optional<Task> existsTaskByCode(String codeTask);
    public void deleteTaskById(Long id);
    public void update(Long id, Task newTask);

    Optional<Task> findTaskSharingByPersonIdAndTaskId(Long idPerson, Long idTask);
}
