package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.infrastructure.usercase.task.ports.TaskRepository;

public record FindTaskByIdImpl(TaskRepository taskRepository) implements FindTaskById {

    @Override
    public Task execute(Long id) {
        return taskRepository.findTaskById(id).orElseThrow();
    }
}
