package dev.elberjsn.todoapi.infrastructure.repositories.tasksharing;

import dev.elberjsn.todoapi.infrastructure.repositories.tasksharing.entities.TaskSharingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskSharingRepository extends JpaRepository<TaskSharingEntity, Long> {

}
