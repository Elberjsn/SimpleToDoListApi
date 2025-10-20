package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.infrastructure.usercase.task.ports.TaskRepository;

public record ExistsTaskByIdImpl(TaskRepository taskRepository) implements ExistsTaskById{
    @Override
    public boolean execute(Long id) {
        return taskRepository.existsTaskById(id);
    }
}
