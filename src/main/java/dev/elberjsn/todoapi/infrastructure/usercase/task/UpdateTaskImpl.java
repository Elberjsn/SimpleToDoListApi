package dev.elberjsn.todoapi.infrastructure.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.core.enuns.TaskStatus;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.infrastructure.usercase.task.dto.RequestTask;
import dev.elberjsn.todoapi.infrastructure.usercase.task.ports.TaskRepository;

public record UpdateTaskImpl(TaskRepository taskRepository) implements UpdateTask {


    @Override
    public void execute(Long idTask, RequestTask newTask) {
        var task = taskRepository.findTaskById(idTask);
        if (task.isEmpty()){
            throw new BusinessException("Task not found");
        }

        taskRepository.update(idTask,
                new Task(
                idTask,
                task.get().code(),
                newTask.title(),
                newTask.description(),
                TaskStatus.fromValue(newTask.taskStatus()),
                TaskLevelSharing.fromValue(newTask.roleStatus()),
                newTask.idPerson(),newTask.particular()));

    }
}
