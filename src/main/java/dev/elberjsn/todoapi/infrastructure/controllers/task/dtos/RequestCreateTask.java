package dev.elberjsn.todoapi.infrastructure.controllers.task.dtos;

public record RequestCreateTask(
        String title, String description, int taskStatus, int roleStatus, Long idPerson, Boolean particular
) {
}
