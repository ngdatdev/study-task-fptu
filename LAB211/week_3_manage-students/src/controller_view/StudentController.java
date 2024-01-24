/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_view;

import model.Course;
import model.Student;
import model.StudentList;
import utils.Library;

/**
 *
 * @author admin
 */
public class StudentController extends Menu {

    private StudentList sList;
    private Library library;

    public StudentController() {
        super("Student management", new String[]{"Create", "Find/Sort", "Update/Delete", "Report", "Exit"});
        sList = new StudentList();
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createStudent();
                break;
            case 2:
                findAndSort();
                break;
            case 3:
                updateAndDelete();
                break;
            case 4:
                reportList();
                break;
            case 5:
                exitMenu();

        }
    }

    public void createStudent() {
        String studentName = library.getString("Enter name of student");
        String semester = library.getString("Enter semester of student");
        String c = library.getString("Enter the name of course");
        Course course = new Course(c);
        Student s = new Student(studentName, semester, course);
        sList.createStudent(s);
    }

    public void findAndSort() {
        new Menu<String>("Find and sort", new String[]{"Find student by name", "Sort by name", "Exit"}) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        String name = library.getString("Enter the name of student to find");
                        System.out.println(sList.findByName(p -> p.getStudentName().contains(name)));
                        break;
                    case 2:
                        sList.sortStudents();
                        System.out.println("Sort successfully");
                        break;
                    case 3:
                        exitMenu();
                }
            }
        }.run();

    }

    public void updateAndDelete() {
        new Menu<String>("Update and delete", new String[]{"Update student", "Delete student by id", "Exit"}) {

            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        int id = library.getInt("Enter the studentID");
                        String studentName = library.getString("Enter name of student");
                        String semester = library.getString("Enter the current semeseter");
                        System.out.println("Current course: (Java, .Net, C/C++)");
                        String c = library.getString("Enter the name of course");
                        Course course = new Course(c);
                        sList.updateStudent(new Student(id, studentName, semester, course));
                        break;
                    case 2:
                        int id2 = library.getInt("Enter the studentID");
                        if(sList.deleteStudent(id2)) {
                            System.out.println("Delete succesfully");
                        } else {
                            System.out.println("Not found id");
                        }
                        
                        break;
                    case 3:
                        exitMenu();
                }
            }
        }.run();
    }

    public void reportList() {
        sList.displayStudents();
    }

}
