package dev.elberjsn.todoapi.core.usercase.repositories.tasksharing;

public interface CreateSharingImpl {
    public boolean execute(Long idTask, Long idPerson);
}
