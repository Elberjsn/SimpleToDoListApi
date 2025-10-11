package dev.elberjsn.todoapi.usercase.task.ports;

import dev.elberjsn.todoapi.core.domain.Task;

import java.util.Optional;

public interface TaskRepository {

    public Task save(Task task);
    public Optional<Task> findTaskById(Long id);
    public Optional<Task> findTaskByIdPerson(Long idPerson);
    public boolean existsTaskById(Long id);
    public Optional<Task> existsTaskByCodeTask(String codeTask);
    public void deleteTaskById(Long id);
    public void update(Long id, Task newTask);
}
