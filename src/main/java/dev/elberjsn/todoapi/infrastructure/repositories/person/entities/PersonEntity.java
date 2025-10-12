package dev.elberjsn.todoapi.infrastructure.repositories.person.entities;

import dev.elberjsn.todoapi.infrastructure.repositories.task.entities.TaskEntity;
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
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String email;
    String password;

    @OneToMany(mappedBy = "person")
    private List<TaskEntity> tasks;

    @OneToMany(mappedBy = "person")
    private List<TaskSharingEntity> taskSharingEntity;

}
