package dev.elberjsn.todoapi.usercase.tasksharing.dto;

public record RequestTaskSharing(
    Long idTask,
    Long idPerson,
    int taskLevelSharing
) {
}
