package dev.elberjsn.todoapi.infrastructure.controllers.sharing.dtos;

public record TaskSharingResponse(
        Long id, Long idTask,String codeTask,String titleTask,
        Long idPerson,String namePerson, Boolean particular,String roleStatus
) {
}
