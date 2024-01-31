/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.Library;
import model.Doctor;
import model.DoctorList;
import view.Menu;

/**
 *
 * @author admin
 */
public class DoctorController extends Menu {

    private DoctorList dl;
    private Library library;

    public DoctorController(DoctorList dl, Library library) {
        super("Doctor management", new String[]{"Add doctor", "Update doctor", "Delete Doctor", "Search Doctor", "Exist"});
        this.dl = dl;
        this.library = library;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                try {
                    addDoctor();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            break;

            case 2: {
                try {
                    updateDoctor();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            break;

            case 3: {
                try {
                    deleteDoctor();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            break;

            case 4: {
                try {
                    searchDoctor();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            break;
            case 5:
                exitMenu();
                break;

        }
    }

    public void addDoctor() throws Exception {
        String code = library.getString("Enter code");
        String name = library.getString("Enter name");
        String specialization = library.getString("Enter specialization");
        int availability = library.getInt("Enter availability");
        Doctor d = new Doctor(code, name, specialization, availability);
        dl.addDoctor(d);
        System.out.println("Add successful");
    }

    public void updateDoctor() throws Exception {
        String code = library.getString("Enter code");
        String name = library.getString("Enter name");
        String specialization = library.getString("Enter specialization");
        int availability = library.getInt("Enter availability");
        Doctor d = new Doctor(code, name, specialization, availability);
        dl.updateDoctor(d);
        System.out.println("Update successful");
    }

    public void deleteDoctor() throws Exception {
        String code = library.getString("Enter code");
        dl.deleteDoctor(code);
        System.out.println("Delete successful");
    }

    public void searchDoctor() throws Exception {
        String keyword = library.getString("Enter the keyword");

        HashMap<String, Doctor> doctorsSearch = dl.searchDoctorBy(keyword);
        if (doctorsSearch.isEmpty()) {
            System.out.println("Not found " + keyword);
        } else {
            System.out.println("--------Search Doctor--------");
            System.out.println(String.format("%-8s%-15s%-20s%-13s", "Code", "Name", "Specialization", "Availability"));
            printDoctors(doctorsSearch);
        }
    }

    private void printDoctors(HashMap<String, Doctor> doctors) {
        for (Doctor d : doctors.values()) {
            System.out.println(d.toString());
        }
    }
}
