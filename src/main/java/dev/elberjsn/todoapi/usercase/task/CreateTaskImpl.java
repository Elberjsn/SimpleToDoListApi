package dev.elberjsn.todoapi.usercase.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.core.enuns.TaskStatus;
import dev.elberjsn.todoapi.usercase.task.dto.RequestTask;
import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;

import java.util.Random;

public record CreateTaskImpl(TaskRepository taskRepository) implements CreateTask {

    @Override
    public Task execute(RequestTask task) {
        String generatedCode = generateCode();
        if (taskRepository.existsTaskByCodeTask(generatedCode).isPresent()){
            generatedCode = generateCode();
        }
        return taskRepository.save(new Task(null,generatedCode ,task.title(),task.description(),
                TaskStatus.fromValue(task.taskStatus()), TaskLevelSharing.fromValue(task.roleStatus()),task.idPerson(),task.particular()));
    }

    private String generateCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
}
