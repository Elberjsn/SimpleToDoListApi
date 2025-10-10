package dev.elberjsn.todoapi.core.usercase.services.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.usercase.repositories.task.FindTaskByPersonIdImpl;

import java.util.Optional;

public class FindTaskByPerson implements FindTaskByPersonIdImpl {


    @Override
    public Optional<Task> execute(Long idPerson) {
        return Optional.empty();
    }
}
