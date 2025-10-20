package dev.elberjsn.todoapi.infrastructure.usercase.tasksharing;


import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.infrastructure.usercase.person.ports.PersonRepository;
import dev.elberjsn.todoapi.infrastructure.usercase.task.ports.TaskRepository;
import dev.elberjsn.todoapi.infrastructure.usercase.tasksharing.ports.TaskSharingRepository;

public record CreateSharingImpl(TaskSharingRepository taskSharingRepository,
                                TaskRepository taskRepository,
                                PersonRepository personRepository) implements CreateSharing {
    @Override
    public TaskSharing execute(TaskSharing taskSharing) {
        if (!taskRepository.existsTaskById(taskSharing.idTask())) {
            throw new BusinessException("Task not found");
        }
        if (!personRepository.existsById(taskSharing.idPerson())) {
            throw new BusinessException("Person not found");
        }


        return taskSharingRepository.save(taskSharing);
    }


}
