package dev.elberjsn.todoapi.infrastructure.usercase.task.dto;

public record RequestTask(
    String title,
    String description,
    int taskStatus,
    int roleStatus,
    Long idPerson,
    Boolean particular
) {
}
