package dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.mapper;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.infrastructure.controllers.sharing.dtos.CreateSharingDto;
import dev.elberjsn.todoapi.infrastructure.controllers.sharing.dtos.TaskSharingResponse;
import dev.elberjsn.todoapi.infrastructure.repositories.person.entities.PersonEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.task.entities.TaskEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.entities.TaskSharingEntity;

public class TaskSharingMapper {

    public static TaskSharing toDomain(TaskSharingEntity entity){
        if (entity == null) return null;
        return TaskSharing.builder(
                entity.getId(),
                entity.getIdTask(),
                entity.getIdPerson(),
                TaskLevelSharing.fromValue(entity.getTaskLevelSharing())
        );
    }
    public static TaskSharingEntity toEntity(TaskSharing taskSharing, PersonEntity person, TaskEntity task){
        if (taskSharing == null) return null;
        return new TaskSharingEntity(
                taskSharing.id(),
                taskSharing.idTask(),
                taskSharing.idPerson(),
                taskSharing.level().getValue() ,
                person,
                task
        );
    }

    public static TaskSharing toDomainDto(CreateSharingDto dto){
        if (dto == null) return null;

        return TaskSharing.builder(
                null,
                dto.idTask(),
                dto.idPerson(),
                TaskLevelSharing.fromValue(dto.level())
        );
    }
    public static TaskSharingResponse toResponseDTO(TaskSharing domain, Task task, Person person){
        if (domain == null || task == null || person == null) return null;

        return new TaskSharingResponse(
                domain.id(),
                domain.idTask(),
                task.code(),
                task.title(),
                domain.idPerson(),
                person.name(),
                task.particular(),
                domain.level().getLabel()
        );
    }
}
