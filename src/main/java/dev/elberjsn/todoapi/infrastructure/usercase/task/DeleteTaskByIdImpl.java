package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.infrastructure.usercase.task.ports.TaskRepository;

public record DeleteTaskByIdImpl(TaskRepository taskRepository) implements DeleteTaskById {
    @Override
    public void execute(Long id) {
        taskRepository.deleteTaskById(id);
    }
}
