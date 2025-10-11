package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;

public record ExistsTaskByIdImpl(TaskRepository taskRepository) implements ExistsTaskById{
    @Override
    public boolean execute(Long id) {
        return taskRepository.existsTaskById(id);
    }
}
