package dev.elberjsn.todoapi.infrastructure.usercase.tasksharing;

public interface DeleteTaskSharingByTaskAndPerson {
    public void execute(Long idTask, Long idPerson);
}
