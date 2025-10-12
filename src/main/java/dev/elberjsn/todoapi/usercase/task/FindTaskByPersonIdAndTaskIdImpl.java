package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;

import java.util.Optional;

public record FindTaskByPersonIdAndTaskIdImpl(TaskRepository taskRepository) implements FindTaskByPersonIdAndTaskId {
    @Override
    public Optional<Task> execute(Long idPerson, Long idTask) {
        return taskRepository.findTaskSharingByPersonIdAndTaskId(idPerson, idTask);
    }
}
