package dev.elberjsn.todoapi.infrastructure.usercase.task.ports;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    public Task save(Task task);
    public Optional<Task> findTaskById(Long id);
    public Optional<Task> findTaskByCode(String code);
    public List<Task> findTaskByIdPerson(Long idPerson);
    public boolean existsTaskById(Long id);
    public Optional<Task> existsTaskByCode(String codeTask);
    public void deleteTaskById(Long id);
    public void update(Long id, Task newTask);
    Optional<Task> findTaskSharingByPersonIdAndTaskId(Long idPerson, Long idTask);


}
