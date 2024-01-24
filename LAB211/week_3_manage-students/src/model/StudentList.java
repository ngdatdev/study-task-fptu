/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author admin
 */
public class StudentList {

    private List<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
        Course course = new Course();
        course.add("Java");
        course.add("Java");
        Course course2 = new Course();
        course2.add(".Net");

        students.add(new Student(1, "Dat", "1", course));
        students.add(new Student(2, "Loi", "2", course2));
        students.add(new Student(3, "Huy", "1", course2));
        students.add(new Student(4, "Giang", "1", course));
        students.add(new Student(5, "Tuan", "1", course));

    }

    public List<Student> getStudents() {
        return students;
    }

    public void createStudent(Student s) {
        int id = students.size() + 1;
        s.setId(id);
        students.add(s);
    }

    public Student findByName(Predicate<Student> p) {
        for (Student s : students) {
            if (p.test(s)) {
                return s;
            }
        }
        return null;
    }

    public void sortStudents() {
        Collections.sort(students);
    }

    public Student updateStudent(Student student) {
        Student sUpdate = null;
        int i = 0;
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setCourse(student.getCourse());
                s.setSemester(student.getSemester());
                s.setStudentName(student.getStudentName());
                sUpdate = s;
                i++;
            }
        }
        students.add(i, student);
        return sUpdate;
    }

    public boolean deleteStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                return true;
            }
        }
        return false;
    }

    public void displayStudents() {
        System.out.println("The report as below: ");
        for (Student s : students) {
            System.out.println(s);
        }
    }

}
