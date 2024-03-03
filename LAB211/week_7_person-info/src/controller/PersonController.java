/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.List;
import model.Person;
import model.PersonList;

/**
 *
 * @author admin
 */

public class PersonController {
    private PersonList personList;
    
    public PersonController(PersonList personList) {
        this.personList = personList;
    }
    
    public void displayInfoPersons(List<Person> persons) {
        personList.setPersons(persons);
        personList.getPersons().forEach((t) -> {
            System.out.println("Information of Person you have entered:");
            t.displayPersonInfo();
        });
    }
}
