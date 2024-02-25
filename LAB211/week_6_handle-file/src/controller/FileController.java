/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.FileHandle;
import model.Person;
import utils.Library;

/**
 *
 * @author admin
 */
public class FileController {

    private FileHandle fileHandle;

    public FileController(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }

    public void displayPersons(String path, Float money) {
        try {
            List<Person> persons = fileHandle.getPerson(path, money);
            System.out.println("==========Result==========");
            System.out.printf("%-10s%-10s%-18s", "Name", "Address", "Money");
            System.out.println("");
            if (persons.isEmpty()) {
                System.out.println("Empty list person");
            } else {
                persons.forEach(p -> System.out.println(p));
                System.out.println("");
                System.out.println("Max: " + persons.get(persons.size() - 1).getName());
                System.out.println("Min: " + persons.get(0).getName());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void copyData(String src, String newFile) {
        try {
            fileHandle.copyWordOneTimes(src, newFile);
            System.out.println("Copy done...");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
