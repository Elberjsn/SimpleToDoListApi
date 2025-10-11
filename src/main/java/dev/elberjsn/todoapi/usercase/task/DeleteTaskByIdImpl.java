package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;

public record DeleteTaskByIdImpl(TaskRepository taskRepository) implements DeleteTaskById {
    @Override
    public void execute(Long id) {
        taskRepository.deleteTaskById(id);
    }
}
