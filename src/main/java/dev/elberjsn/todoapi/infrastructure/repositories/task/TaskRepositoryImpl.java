package dev.elberjsn.todoapi.infrastructure.repositories.task;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.exceptions.BusinessException;
import dev.elberjsn.todoapi.infrastructure.repositories.person.PersonRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.task.entities.TaskEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.task.mapper.TaskEntityMapper;
import dev.elberjsn.todoapi.usercase.task.ports.TaskRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final JpaTaskRepository jpaTaskRepository;
    private final PersonRepositoryImpl personRepository;

    public TaskRepositoryImpl(JpaTaskRepository jpaTaskRepository, PersonRepositoryImpl personRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Task save(Task task) {
        try {
            TaskEntity entity = TaskEntityMapper.toEntity(task,null);
            TaskEntity save = jpaTaskRepository.save(entity);
            return TaskEntityMapper.toDomain(save);
        } catch (RuntimeException e) {
            throw new BusinessException("Error creating task",e.getCause());
        }
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return Optional.ofNullable(TaskEntityMapper.toDomain(
                jpaTaskRepository.findById(id).orElse(null)
        ));
    }

    @Override
    public Optional<Task> findTaskByCode(String code) {
        return Optional.ofNullable(jpaTaskRepository.findByCode(code).orElse(null));

    }

    @Override
    public List<Task> findTaskByIdPerson(Long idPerson) {
        return jpaTaskRepository.findTaskEntitiesByPersonId(idPerson);
    }

    @Override
    public boolean existsTaskById(Long id) {
        return jpaTaskRepository.existsById(id);
    }

    @Override
    public Optional<Task> existsTaskByCode(String codeTask) {
        return jpaTaskRepository.findTaskEntitiesByCode(codeTask);
    }

    @Override
    public void deleteTaskById(Long id) {
        try {
            jpaTaskRepository.deleteById(id);
        }catch (RuntimeException e){
            throw new BusinessException("Error deleting task",e.getCause());
        }
    }

    @Override
    public void update(Long id, Task newTask) {
        if(!existsTaskById(id)){
            throw new BusinessException("Id Task not found");
        }

        Task taskToUpdate = new Task(id, newTask.code(), newTask.title(), newTask.description(),
                newTask.status(), newTask.roleTask(), newTask.idPerson(), newTask.particular());
        Person person = personRepository.findById(newTask.idPerson()).orElseThrow();
        jpaTaskRepository.save(TaskEntityMapper.toEntity(taskToUpdate,person));
    }

    @Override
    public Optional<Task> findTaskSharingByPersonIdAndTaskId(Long idPerson, Long idTask) {
        return jpaTaskRepository.findTaskEntitiesByIdAndPersonId(idPerson,idTask);
    }
}
