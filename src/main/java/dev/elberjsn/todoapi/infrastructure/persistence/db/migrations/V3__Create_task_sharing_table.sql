CREATE TABLE task_sharing (
                               id BIGSERIAL PRIMARY KEY,
                               task_id BIGINT NOT NULL,
                               shared_with_person_id BIGINT NOT NULL,
                               permission_level VARCHAR(20) NOT NULL DEFAULT 'VIEW',
                               shared_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                               CONSTRAINT fk_sharing_task
                                   FOREIGN KEY (task_id)
                                       REFERENCES tasks(id)
                                       ON DELETE CASCADE,

                               CONSTRAINT fk_sharing_person
                                   FOREIGN KEY (shared_with_person_id)
                                       REFERENCES persons(id)
                                       ON DELETE CASCADE,

                               CONSTRAINT uk_task_shared_with
                                   UNIQUE (task_id, shared_with_person_id)
);

CREATE INDEX idx_task_sharing_task_id ON task_sharing(task_id);
CREATE INDEX idx_task_sharing_person_id ON task_sharing(shared_with_person_id);