package dev.elberjsn.todoapi.core.enuns;

public enum TaskLevelSharing {
    READ_ONLY(0),
    READ_WRITE(1),
    ADMIN(2);

    private final int value;
    private TaskLevelSharing(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TaskLevelSharing fromValue(int value) {
        for (TaskLevelSharing status : TaskLevelSharing.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;
    }
}
