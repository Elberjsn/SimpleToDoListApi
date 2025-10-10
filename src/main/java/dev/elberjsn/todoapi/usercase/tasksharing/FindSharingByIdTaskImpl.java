package dev.elberjsn.todoapi.usercase.tasksharing;

import dev.elberjsn.todoapi.core.domain.Person;

import java.util.List;

public interface FindSharingByIdTaskImpl {
    public List<Person> execute(Long idTask);
}
