package dev.elberjsn.todoapi.infrastructure.repositories.task;

import dev.elberjsn.todoapi.core.domain.Task;
import dev.elberjsn.todoapi.infrastructure.repositories.task.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {

    Optional<Task> findTaskEntitiesByPersonId(Long personId);

    Optional<Task> findTaskEntitiesByCode(String codeTask);
    Optional<Task> findTaskEntitiesByIdAndPersonId(Long id, Long personId);
}
