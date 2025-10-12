package dev.elberjsn.todoapi.infrastructure.repositories.tasksharing;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.infrastructure.repositories.person.PersonRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.person.mapper.PersonEntityMapper;
import dev.elberjsn.todoapi.infrastructure.repositories.task.TaskRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.task.entities.TaskEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.task.mapper.TaskEntityMapper;
import dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.entities.TaskSharingEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.mapper.TaskSharingMapper;
import dev.elberjsn.todoapi.usercase.tasksharing.dto.RequestTaskSharing;
import dev.elberjsn.todoapi.usercase.tasksharing.ports.TaskSharingRepository;

import java.util.Optional;

public class TaskSharingRepositoryImpl implements TaskSharingRepository {

    private final JpaTaskSharingRepository jpaTaskSharingRepository;
    private final PersonRepositoryImpl personRepository;
    private final TaskRepositoryImpl taskRepository;

    public TaskSharingRepositoryImpl(JpaTaskSharingRepository jpaTaskSharingRepository, PersonRepositoryImpl personRepository, TaskRepositoryImpl taskRepository) {
        this.jpaTaskSharingRepository = jpaTaskSharingRepository;
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }


    @Override
    public TaskSharing save(TaskSharing taskSharing) {


        try {
            Person p = personRepository.findById(taskSharing.idPerson()).orElse(null);
            Task t = taskRepository.findTaskById(taskSharing.idTask()).orElse(null);

            TaskSharingEntity entity = TaskSharingMapper.toEntity(taskSharing, PersonEntityMapper.toEntity(p), TaskEntityMapper.toEntity(t,null));
            TaskSharingEntity save = jpaTaskSharingRepository.save(entity);
            return TaskSharingMapper.toDomain(save);

        }catch (RuntimeException e){
            throw new RuntimeException("Error creating task sharing",e.getCause());
        }

    }

    @Override
    public void updateTaskSharing(Long id, RequestTaskSharing taskSharing) {
        var task = taskRepository.findTaskById(id);
        if(task.isEmpty()){
            throw new BusinessException("Id Task not found");
        }

        TaskSharing taskToUpdate = new TaskSharing(
                id,
                taskSharing.idTask(),
                taskSharing.idPerson(),
                TaskLevelSharing.fromValue(taskSharing.taskLevelSharing())
        );
        Person person = personRepository.findById( taskSharing.idPerson()).orElseThrow();
        jpaTaskSharingRepository.save(
                TaskSharingMapper.toEntity(taskToUpdate, PersonEntityMapper.toEntity(person), TaskEntityMapper.toEntity(task.get(),null))
        );

    }

    @Override
    public void deleteTaskSharingByTaskAndPerson(RequestTaskSharing taskSharing) {
        jpaTaskSharingRepository.deleteById(taskSharing.idTask());
    }
    @Override
    public Optional<TaskSharing> existsTaskSharingById(Long id) {
        return Optional.ofNullable(TaskSharingMapper.toDomain(
                jpaTaskSharingRepository.findById(id).orElse(null)
        ));
    }
    @Override
    public Optional<Task> findTaskEntitiesByIdAndPersonId(Long idTask, Long idPerson) {
        return Optional.empty();
    }
}
