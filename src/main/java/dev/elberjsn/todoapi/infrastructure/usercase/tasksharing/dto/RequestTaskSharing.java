package dev.elberjsn.todoapi.infrastructure.usercase.tasksharing.dto;

public record RequestTaskSharing(
    Long idTask,
    Long idPerson,
    int taskLevelSharing
) {
}
