package dev.elberjsn.todoapi.core.usercase.services.tasksharing;

import dev.elberjsn.todoapi.core.usercase.repositories.tasksharing.CreateSharingImpl;

import java.util.Random;

public class CreateSharing implements CreateSharingImpl {
    @Override
    public boolean execute(Long idTask, Long idPerson) {
        return new Random().nextBoolean();
    }
}
