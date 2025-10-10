package dev.elberjsn.todoapi.core.usercase.repositories.tasksharing;

import dev.elberjsn.todoapi.core.domain.Person;

import java.util.List;

public interface FindSharingByIdTaskImpl {
    public List<Person> execute(Long idTask);
}
