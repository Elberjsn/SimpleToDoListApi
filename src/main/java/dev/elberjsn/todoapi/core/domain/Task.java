package dev.elberjsn.todoapi.core.domain;

import dev.elberjsn.todoapi.core.enuns.TaskStatus;

public record Task(
        Long id, String code, String title, String description, TaskStatus status, String RoleTask, Long idPerson, Boolean particular
) {
}
