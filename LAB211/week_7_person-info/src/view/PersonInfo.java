/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.PersonController;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import utils.Library;

/**
 *
 * @author admin
 */
public class PersonInfo extends Menu {

    private PersonController personController;
    private Library library;

    public PersonInfo(PersonController personController) {
        super("Person Information", new String[]{"Press to add and display info", "Exit"});
        this.personController = personController;
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                List<Person> persons = new ArrayList<>();
                for (int i = 0; i < 3; i++) {

                    try {
                        String name = library.getString("Name");
                        String address = library.getString("Address");
                        String salary = library.getString("Salary");
                        System.out.println("-----------------------");
                        Person p = Person.inputPersonInfo(name, address, salary);
                        persons.add(p);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        i--;
                    }

                }
                personController.displayInfoPersons(persons);
                break;
            case 2:
                exitMenu();
                break;

        }
    }

}
