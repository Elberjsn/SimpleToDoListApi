package dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.entities;

import dev.elberjsn.todoapi.infrastructure.repositories.person.entities.PersonEntity;
import dev.elberjsn.todoapi.infrastructure.repositories.task.entities.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "task_sharing")
public class TaskSharingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idTask;
    private Long idPerson;
    private int taskLevelSharing;

    @ManyToOne
    @JoinColumn(name = "person")
    PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "task")
    TaskEntity task;
}
