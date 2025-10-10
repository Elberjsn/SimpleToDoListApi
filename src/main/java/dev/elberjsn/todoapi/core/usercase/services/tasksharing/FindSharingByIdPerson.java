package dev.elberjsn.todoapi.core.usercase.services.tasksharing;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.usercase.repositories.tasksharing.FindSharingByIdTaskImpl;

import java.util.List;

public class FindSharingByIdPerson implements FindSharingByIdTaskImpl {

    @Override
    public List<Person> execute(Long idTask) {
        return List.of();
    }
}
