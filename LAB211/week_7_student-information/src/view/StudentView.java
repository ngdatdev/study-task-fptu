/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.StudentController;
import model.Student;
import model.StudentList;
import utils.Library;

/**
 *
 * @author admin
 */
public class StudentView extends Menu<String> {

    private StudentController studentController;
    private Library library;
    
    public StudentView(StudentController studentController) {
        super("Student Information", new String[]{"Add student", "Sort and Display students list", "Exit"});
        this.studentController = studentController;
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String name = library.getString("Enter name");
                String classes = library.getString("Enter classes");
                double mark = library.getDouble("Enter mark");
                studentController.addStudent(new Student(name, classes, mark));
                break;
            case 2:
                studentController.sortAndDisplayList();
                break;
            case 3: 
                exitMenu();
                break;
        }
    }

}
