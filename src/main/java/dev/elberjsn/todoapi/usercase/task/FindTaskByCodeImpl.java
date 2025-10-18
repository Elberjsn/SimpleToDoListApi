package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;

public record FindTaskByCodeImpl(TaskRepository taskRepository) implements FindTaskByCode {

    @Override
    public Task execute(String code) {
        return taskRepository.findTaskByCode(code).orElseThrow();
    }
}
