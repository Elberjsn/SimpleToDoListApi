package dev.elberjsn.todoapi.core.domain;

import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.core.enuns.TaskStatus;

public record Task(
        Long id, String code, String title, String description, TaskStatus status, TaskLevelSharing roleTask, Long idPerson, Boolean particular
) {

    public static Task builder(Long id, String code, String title, String description, TaskStatus status, TaskLevelSharing roleTask, Long idPerson, Boolean particular) {
        return new Task(id, code, title, description, status, roleTask, idPerson, particular);
    }
}
