package dev.elberjsn.todoapi.core.enuns;

public enum TaskStatus {
    ACTIVE(0),
    COMPLETED(1),
    DELETED(2),
    IN_PROGRESS(3),
    PENDING(4),
    REVOKED(5);

    private final int value;
    private TaskStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
