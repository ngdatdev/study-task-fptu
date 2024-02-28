/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Student;
import model.StudentList;

/**
 *
 * @author admin
 */
public class StudentController {
    private StudentList studentList;
    
    public StudentController(StudentList studentList) {
        this.studentList = studentList;
    }
    
    public void addStudent(Student s) {
        studentList.addStudent(s);
    }
    
    public void sortAndDisplayList() {
        studentList.sortStudent();
        studentList.displayStudents();
    }
    
    
}
