package dev.elberjsn.todoapi.core.usercase.services.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.enuns.TaskStatus;
import dev.elberjsn.todoapi.core.usercase.repositories.task.CreateTaskImpl;

import java.util.Random;

public class CreateTask implements CreateTaskImpl {


    @Override
    public Task execute(Task task) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            code.append(characters.charAt(random.nextInt(characters.length())));
        }
        return new Task(new Random().nextLong(), code.toString(), task.title(), task.description(), task.status(),task.RoleTask(), task.idPerson(), task.particular());
    }
}
