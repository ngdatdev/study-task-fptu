/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class TaskList {

    private List<Task> tasks;
    private int lastId;

    public TaskList() {
        tasks = new ArrayList<>();
        lastId = 0;
    }

    public int addTask(String requirementName, String date, int taskTypeID, double from, double to, String assignee, String reviewer) throws Exception {
        lastId++;

        if (taskTypeID < 1 || taskTypeID > 4) {
            throw new IllegalArgumentException("Invalid Task Type ID. Please enter a value between 1 and 4.");
        }

//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date d = dateFormat.parse(date);

        if (from >= to || from < 8.0 || to > 17.5) {
            throw new IllegalArgumentException("Invalid Plan From/To time. Plan From must be less than Plan To and within 8:00 AM to 5:30 PM.");
        }

        Task newTask = new Task(lastId, taskTypeID, requirementName, date, from, to, assignee, reviewer);
        tasks.add(newTask);
        return lastId;
    }

    public void deleteTask(int id) throws Exception {
        Task taskToDelete = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                taskToDelete = task;
                break;
            }
        }
        if (taskToDelete == null) {
            throw new IllegalArgumentException("Task with ID " + id + " does not exist.");
        }
        tasks.remove(taskToDelete);
    }

    public List<Task> getDataTasks() {
        return tasks;
    }
}
