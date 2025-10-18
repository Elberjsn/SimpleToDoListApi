package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;

import java.util.List;

public record FindTaskByPersonIdImpl(TaskRepository taskRepository) implements FindTaskByPersonId {
    @Override
    public List<Task> execute(Long idPerson) {
        return taskRepository.findTaskByIdPerson(idPerson);
    }
}
