/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class FileHandle {

    private List<Person> persons;

    public FileHandle() {
    }

    public List<Person> getPerson(String filePath, Float money) throws Exception {
        readDataFromFile(filePath);
        List<Person> ps = new ArrayList<>();
        persons.forEach(p -> {
            if (p.getSalary() >= money) {
                ps.add(p);
            }
        });
        ps.sort((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));

        return ps;
    }

    public void copyWordOneTimes(String source, String destination) throws Exception {
        readDataFromFile(source);
        
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (Person person : persons) {
                String line = person.getName() + ";" + person.getAddress() + ";" + person.getSalary();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new Exception("Can't write file");
        }
    }

    private void readDataFromFile(String path) throws Exception {
        persons = new ArrayList<>();
        if(!(new File(path).exists())) {
            throw new Exception("Path doesn't exist");
        }
        // check path
        try ( Scanner sc = new Scanner(new File(path))) {
            while (sc.hasNextLine()) {
                String person = sc.nextLine();
                String[] fields = person.split(";");
                persons.add(new Person(fields[0], fields[1], Float.parseFloat(fields[2])));
            }
        } catch (Exception e) {
            throw new Exception("Can’t read file");
        }
    }
}
