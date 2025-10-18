package dev.elberjsn.todoapi.infrastructure.repositories.task.mapper;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.core.enuns.TaskStatus;
import dev.elberjsn.todoapi.infrastructure.controllers.task.dtos.RequestCreateTask;
import dev.elberjsn.todoapi.infrastructure.controllers.task.dtos.TaskResponse;
import dev.elberjsn.todoapi.infrastructure.repositories.person.mapper.PersonEntityMapper;
import dev.elberjsn.todoapi.infrastructure.repositories.task.entities.TaskEntity;

public class TaskEntityMapper {

    public static Task toDomain(TaskEntity entity) {
        if (entity == null) return null;

        return Task.builder(
                entity.getId(),
                entity.getCode(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getRoleTask(),
                entity.getIdPerson(),
                entity.isParticular()
        );
    }

    public static TaskEntity toEntity(Task domain, Person person) {
        if (domain == null) return null;

        return new TaskEntity(
                domain.id(),
                domain.code(),
                domain.title(),
                domain.description(),
                domain.status(),
                domain.roleTask(),
                domain.idPerson(),
                domain.particular(),
                PersonEntityMapper.toEntity(person),
                null
        );
    }

    public static Task ToDomainDTO(RequestCreateTask entity) {
        if (entity == null) return null;

        return Task.builder(
                null,
                null,
                entity.title(),
                entity.description(),
                TaskStatus.fromValue(entity.taskStatus()),
                TaskLevelSharing.fromValue(entity.roleStatus()),
                entity.idPerson(),
                entity.particular()
        );
    }
    public static TaskResponse ToResponseDTO(Task domain){
        if (domain == null) return null;

        return new TaskResponse(
                domain.id(),
                domain.code(),
                domain.title(),
                domain.description(),
                domain.status().name(),
                domain.roleTask().name(),
                domain.idPerson(),
                domain.particular()
        );
    }
}
