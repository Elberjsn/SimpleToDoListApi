package dev.elberjsn.todoapi.infrastructure.controllers.sharing.dtos;

public record CreateSharingDto(
        Long idTask, Long idPerson, int level
) {
}
