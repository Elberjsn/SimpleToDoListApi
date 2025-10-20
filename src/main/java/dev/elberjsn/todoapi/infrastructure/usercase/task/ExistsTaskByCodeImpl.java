package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.infrastructure.usercase.task.ports.TaskRepository;

import java.util.Optional;

public record ExistsTaskByCodeImpl(TaskRepository taskRepository) implements ExistsTaskByCode{
    @Override
    public Optional<Task> execute(String code) {
        return taskRepository.existsTaskByCode(code);
    }
}
