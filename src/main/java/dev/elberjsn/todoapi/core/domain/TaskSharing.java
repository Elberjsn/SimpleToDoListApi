package dev.elberjsn.todoapi.core.domain;

import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;

public record TaskSharing(
        Long id, Long idTask, Long idPerson, TaskLevelSharing level
) {
    public static TaskSharing builder(Long id, Long idTask, Long idPerson, TaskLevelSharing level) {
        return new TaskSharing(id, idTask, idPerson, level);
    }
}
