
package main;

import controller.PersonController;
import model.PersonList;
import view.PersonInfo;


public class App {
    public static void main(String[] args) {
        new PersonInfo(new PersonController(new PersonList())).run();
    }
}
