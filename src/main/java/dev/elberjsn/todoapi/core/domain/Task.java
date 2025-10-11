package dev.elberjsn.todoapi.core.domain;

import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.core.enuns.TaskStatus;

public record Task(
        Long id, String code, String title, String description, TaskStatus status, TaskLevelSharing RoleTask, Long idPerson, Boolean particular
) {
}
