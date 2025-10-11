package dev.elberjsn.todoapi.usercase.task.dto;

public record RequestTask(
    String title,
    String description,
    int taskStatus,
    int roleStatus,
    Long idPerson,
    Boolean particular
) {
}
