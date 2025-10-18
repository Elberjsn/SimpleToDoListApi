package dev.elberjsn.todoapi.infrastructure.controllers.task.dtos;

public record TaskResponse(
        Long id, String code, String title, String description, String taskStatus, String roleStatus, Long idPerson, Boolean particular
) {
}
