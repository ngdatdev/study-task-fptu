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
public class Course {

    private List<String> course = new ArrayList<>();

    public Course() {
    }

    public Course(String course) {

        this.course.add(course);
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public void add(String c) {
        course.add(c);
    }

    public boolean getCourseName(String n) {
        for (String s : course) {
            if (s.equals(n)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return course.size();
    }

}
