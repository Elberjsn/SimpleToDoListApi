CREATE TABLE task (
                       id BIGSERIAL PRIMARY KEY,
                       code VARCHAR(50) UNIQUE NOT NULL,
                       title VARCHAR(200) NOT NULL,
                       description TEXT,
                       status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
                       priority VARCHAR(20) NOT NULL DEFAULT 'MEDIUM',
                       due_date TIMESTAMP,
                       person_id BIGINT NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                       CONSTRAINT fk_task_person
                           FOREIGN KEY (person_id)
                               REFERENCES persons(id)
                               ON DELETE CASCADE
);

CREATE INDEX idx_tasks_person_id ON task(person_id);
CREATE INDEX idx_tasks_status ON task(status);
CREATE INDEX idx_tasks_due_date ON task(due_date);
CREATE UNIQUE INDEX idx_tasks_code_unique ON task(code);

COMMENT ON COLUMN task.status IS 'Status da tarefa: PENDING, IN_PROGRESS, COMPLETED, CANCELLED';