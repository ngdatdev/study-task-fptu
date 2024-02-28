/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class StudentList {

    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void sortStudent() {
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    public void displayStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("----------Student " + i + 1 + "-----------");
            System.out.println("Name: " + students.get(i).getName());
            System.out.println("Classes: " + students.get(i).getClasses());
            System.out.println("Mark: " + students.get(i).getMark());
        }
    }
}
