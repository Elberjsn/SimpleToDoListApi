package dev.elberjsn.todoapi.infrastructure.controllers.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.infrastructure.controllers.task.dtos.RequestCreateTask;
import dev.elberjsn.todoapi.infrastructure.controllers.task.dtos.TaskResponse;
import dev.elberjsn.todoapi.infrastructure.repositories.task.TaskRepositoryImpl;
import dev.elberjsn.todoapi.infrastructure.repositories.task.mapper.TaskEntityMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person/task")
public class TaskController{

    final TaskRepositoryImpl taskRepository;
    public TaskController(TaskRepositoryImpl taskRepository) {
        this.taskRepository = taskRepository;
    }

   @PostMapping("/create")
    public ResponseEntity<TaskResponse> createTask(@RequestBody RequestCreateTask newTask){

       Task t = taskRepository.save(TaskEntityMapper.ToDomainDTO(newTask));
         if (t == null){
              return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build() ;
         }

       return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(TaskEntityMapper.ToResponseDTO(t));
   }

   @GetMapping("/findById/{id}")
   public ResponseEntity<TaskResponse> findTaskById(@PathVariable String id){
        Long idTask = Long.parseLong(id);
        Task t = taskRepository.findTaskById(idTask).orElse(null);
        if (t == null){
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(TaskEntityMapper.ToResponseDTO(t));
   }
    @GetMapping("/{id}")
    public ResponseEntity<List<TaskResponse>> findTaskByIdPerson(@PathVariable String id){
        Long idTask = Long.parseLong(id);
        List<Task> t = taskRepository.findTaskByIdPerson(idTask);
        if (t.isEmpty()){
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpServletResponse.SC_OK)
                .body(
                        t.stream().map(TaskEntityMapper::ToResponseDTO).toList()
                );

    }
    @GetMapping("/findByCode/{code}")
    public ResponseEntity<TaskResponse> findTaskByCode(@PathVariable String code){
        Task t = taskRepository.findTaskById(Long.parseLong(code)).orElse(null);
        if (t == null){
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(TaskEntityMapper.ToResponseDTO(t));
    }
   @PutMapping("/update/{id}")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody RequestCreateTask newTask, @PathVariable String id){
        Long idTask = Long.parseLong(id);
        taskRepository.update(idTask, TaskEntityMapper.ToDomainDTO(newTask));
        return ResponseEntity.status(HttpServletResponse.SC_OK).build();
   }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable String id){
        Long idTask = Long.parseLong(id);
        taskRepository.deleteTaskById(idTask);
        return ResponseEntity.status(HttpServletResponse.SC_OK).build();
   }

}
