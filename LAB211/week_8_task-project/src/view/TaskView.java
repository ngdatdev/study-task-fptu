/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.TaskController;
import library.Library;

/**
 *
 * @author admin
 */
public class TaskView extends Menu {

    private TaskController taskController;
    private Library library;

    public TaskView() {
        super("Dev Task", new String[]{"Add task", "Delete task", "Display tasks", "Exit"});
        taskController = new TaskController();
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String name = library.getString("Requirement Name");
                int taskType = library.getInt("Task Type");
                String date = library.getString("Date");
                double from = library.getDouble("From");
                double to = library.getDouble("To");
                String assignee = library.getString("Assignee");
                String reviewer = library.getString("Reviewer");
                taskController.addTask(name, taskType, date, from, to, assignee, reviewer);
                break;
            case 2:
                int id = library.getInt("Id task");
                taskController.deleteTask(id);
                break;
            case 3:
                taskController.displayTasks();
                break;
            case 4:
                exitMenu();
                break;
        }
    }

}
