CREATE INDEX idx_persons_created_at ON person(created_at);
CREATE INDEX idx_tasks_created_at ON task(created_at);
CREATE INDEX idx_tasks_person_status ON task(person_id, status);