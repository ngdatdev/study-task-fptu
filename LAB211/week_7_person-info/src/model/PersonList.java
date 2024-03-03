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
public class PersonList {
    private List<Person> persons;
    
    public PersonList() {
        persons = new ArrayList<>();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }
    
    public void addPerson(Person p) {
        persons.add(p);
    }
    
    public void sortList() {
        persons.sort((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
    }
}
