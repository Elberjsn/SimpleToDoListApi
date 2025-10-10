package dev.elberjsn.todoapi.usercase.tasksharing;

public interface CreateSharingImpl {
    public boolean execute(Long idTask, Long idPerson);
}
