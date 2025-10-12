package dev.elberjsn.todoapi.infrastructure.repositories.task.entities;

import dev.elberjsn.todoapi.core.enuns.TaskLevelSharing;
import dev.elberjsn.todoapi.core.enuns.TaskStatus;
import dev.elberjsn.todoapi.infrastructure.repositories.person.entities.PersonEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.entities.TaskSharingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskLevelSharing roleTask;
    private Long idPerson;
    private boolean particular;

    //Relacionamento
    @ManyToOne
    @JoinColumn(name = "person")
    PersonEntity person;

    @OneToMany(mappedBy = "task")
    private List<TaskSharingEntity> taskSharingEntity;
}
