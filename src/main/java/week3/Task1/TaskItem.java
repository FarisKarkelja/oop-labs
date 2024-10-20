package week3.Task1;

enum Status {
    TO_DO, IN_PROGRESS, COMPLETED, CANCELLED
}

public class TaskItem {
    private int taskId;
    private String taskDescription;
    private Status taskStatus;

    public TaskItem(int taskId, String taskDescription, Status taskStatus) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    public void printInformation() {
        System.out.println(
                "ID: " + taskId +
                " Task Description: " + taskDescription +
                " Task Status: " + taskStatus
        );
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }
}


