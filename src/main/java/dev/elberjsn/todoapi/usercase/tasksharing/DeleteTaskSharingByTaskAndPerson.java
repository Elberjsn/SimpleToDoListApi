package dev.elberjsn.todoapi.usercase.tasksharing;

public interface DeleteTaskSharingByTaskAndPerson {
    public void execute(Long idTask, Long idPerson);
}
