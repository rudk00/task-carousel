package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private final int capacity;
    private int index = 0;
    private final List<Task> taskList = new ArrayList<>();

    public TaskCarousel(int capacity) {
        if (capacity < 0) {
            throw new UnsupportedOperationException();
        }
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        if (!isFull() && !task.isFinished()) {
            taskList.add(task);
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        if (index >= taskList.size()) index = 0;
        taskList.get(index).execute();
        if (taskList.get(index).isFinished()) {
            taskList.remove(index);
        } else {
            index++;
        }
        return true;
    }

    public boolean isFull() {
        return taskList.size() == capacity;
    }

    public boolean isEmpty() {
        return taskList.size() == 0;
    }
}