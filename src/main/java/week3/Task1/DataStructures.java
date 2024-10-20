package week3.Task1;

import java.util.ArrayList;
import java.util.Collections;

public class DataStructures {
    public static void main(String[] args) {
        ArrayList<TaskItem> tasks = new ArrayList<TaskItem>();

        Collections.addAll(tasks,
                new TaskItem(1, "Push lab code to the github", Status.TO_DO),
                new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab2", Status.COMPLETED)
        );

        getAllObjects(tasks);
        getByStatus(tasks, Status.TO_DO);
        getById(tasks);
        getDescription(tasks);
    }

    public static void getAllObjects(ArrayList<TaskItem> tasks) {
        for (TaskItem task : tasks) {
            task.printInformation();
        }
    }

    public static void getByStatus(ArrayList<TaskItem> tasks, Status status) {
        for (TaskItem task : tasks) {
            if (task.getTaskStatus() == status) {
                task.printInformation();
            }
        }
    }

    public static void getById(ArrayList<TaskItem> tasks) {
        for (TaskItem task : tasks) {
            if (task.getTaskId() >= 2) {
                task.printInformation();
            }
        }
    }

    public static void getDescription(ArrayList<TaskItem> tasks) {
        tasks.forEach(task -> System.out.println(task.getTaskDescription()));
    }
}
