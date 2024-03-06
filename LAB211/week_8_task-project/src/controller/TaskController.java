/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Task;
import model.TaskList;

/**
 *
 * @author admin
 */
public class TaskController {

    private TaskList taskList;

    public TaskController() {
        taskList = new TaskList();
    }

    public void addTask(String requirementName, int taskTypeID, String date, double planFrom, double planTo, String assignee, String reviewer) {
        try {
            taskList.addTask(requirementName, date, taskTypeID, planFrom, planTo, assignee, reviewer);
            System.out.println("Add successfully");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteTask(int id) {
        try {
            taskList.deleteTask(id);
            System.out.println("Delete successfully");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void displayTasks() {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        if(taskList.getDataTasks().isEmpty()) {
            System.out.println("Not found task");
        }
        System.out.println(String.format("%-3s %-15s %-12s %-12s %-8s %-8s %-12s %-12s",
                             "ID", "Name", "Task Type", "Date", "From", "To", "Assignee", "Reviewer"));
        
        for (Task t : taskList.getDataTasks()) {
            System.out.println(t);
        }
    }
}
