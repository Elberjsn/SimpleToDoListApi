package dev.elberjsn.todoapi.infrastructure.controllers.sharing;

import dev.elberjsn.todoapi.core.domain.Person;
import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.core.domain.TaskSharing;
import dev.elberjsn.todoapi.infrastructure.controllers.sharing.dtos.CreateSharingDto;
import dev.elberjsn.todoapi.infrastructure.controllers.sharing.dtos.TaskSharingResponse;
import dev.elberjsn.todoapi.infrastructure.repositories.person.PersonRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.task.TaskRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.TaskSharingRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.mapper.TaskSharingMapper;
import dev.elberjsn.todoapi.infrastructure.usercase.tasksharing.dto.RequestTaskSharing;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/person/task/sharing")
public class TaskSharingController {

    final TaskSharingRepositoryImpl taskSharingRepository;
    final PersonRepositoryImpl personRepository;
    final TaskRepositoryImpl taskRepository;
    public TaskSharingController(TaskSharingRepositoryImpl taskSharingRepository, PersonRepositoryImpl personRepository, TaskRepositoryImpl taskRepository) {
        this.taskSharingRepository = taskSharingRepository;
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }



    @PostMapping("/create")
    public ResponseEntity<TaskSharingResponse> createTaskSharing(@RequestBody CreateSharingDto taskSharing){

        TaskSharing sharing= taskSharingRepository.save(TaskSharingMapper.toDomainDto(taskSharing));
        if (sharing == null){
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
        Task t = taskRepository.findTaskById(taskSharing.idTask()).get();
        Person p = personRepository.findById(taskSharing.idPerson()).get();

        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(createResponse(sharing));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskSharingResponse> updateTaskSharing(@RequestBody CreateSharingDto taskSharing,@PathVariable String id){
        Long idSharing = Long.parseLong(id);

        RequestTaskSharing ts = new RequestTaskSharing(
                taskSharing.idTask(),
                taskSharing.idPerson(),
                taskSharing.level()
        );
        taskSharingRepository.updateTaskSharing(idSharing,ts);
        Optional<TaskSharing> sharing = taskSharingRepository.existsTaskSharingById(idSharing);
        if (sharing.isEmpty()){
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpServletResponse.SC_OK).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TaskSharingResponse> deleteSharing(@PathVariable String id){
        Long idSharing = Long.parseLong(id);
        taskRepository.deleteTaskById(idSharing);
        return ResponseEntity.status(HttpServletResponse.SC_OK).build();
    }


    private TaskSharingResponse createResponse(TaskSharing sharing){
        Task t = taskRepository.findTaskById(sharing.idTask()).get();
        Person p = personRepository.findById(sharing.idPerson()).get();
        return TaskSharingMapper.toResponseDTO(sharing,t,p);
    }
}
