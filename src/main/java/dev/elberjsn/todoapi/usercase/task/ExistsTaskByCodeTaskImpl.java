package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;

import java.util.Optional;

public record ExistsTaskByCodeTaskImpl(TaskRepository taskRepository) implements ExistsTaskByCodeTask{
    @Override
    public Optional<Task> execute(String code) {
        return taskRepository.existsTaskByCodeTask(code);
    }
}
