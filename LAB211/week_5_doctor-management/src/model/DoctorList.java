/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class DoctorList {

    private HashMap<String, Doctor> doctors;

    public DoctorList() {
        doctors = new HashMap<>();
//        doctors.put("1", new Doctor("1", "Dat", "haha"));
//        doctors.put("2", new Doctor("2", "Huy", "haha"));
//        doctors.put("1", new Doctor("1", "Dat", "haha"));
        readFile("doctor.txt");
    }

    public HashMap<String, Doctor> getDoctors() {
        return doctors;
    }

    public void addDoctor(Doctor d) throws Exception {
        if (d.getCode().isEmpty()) {
            throw new Exception("Code is not null!");
        }
        if (doctors.isEmpty()) {
            throw new Exception("Database is null");
        }

        if (!doctors.containsKey(d.getCode())) {
            throw new Exception("Code is duplication in DB");
        }
        doctors.put(d.getCode(), d);

    }

    public Doctor updateDoctor(Doctor d) throws Exception {
        if (doctors.isEmpty()) {
            throw new Exception("Database does not exist");
        }
        if (d.getCode().isEmpty()) {
            throw new Exception("Data doesn't exist");
        }

        if (!doctors.containsKey(d.getCode())) {
            throw new Exception("Doctor code doesn't exist");
        }
        return doctors.put(d.getCode(), d);
    }

    public void deleteDoctor(String code) throws Exception {
        if (doctors.isEmpty()) {
            throw new Exception("Database does not exist");
        }
        if (code.isEmpty()) {
            throw new Exception("Code doesn't exist");
        }

        if (!doctors.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctors.remove(code);

    }

    public HashMap<String, Doctor> searchDoctorBy(String keyword) throws Exception {
        if (doctors.isEmpty()) {
            throw new Exception("Database does not exist");
        }
        if (keyword.isEmpty()) {
            throw new Exception("Code doesn't exist");
        }

        HashMap<String, Doctor> docSearch = new HashMap<>();

        for (Doctor d : doctors.values()) {
            if (d.appending().toLowerCase().trim().contains(keyword.toLowerCase().trim())) {
                docSearch.put(d.getCode(), d);
            }
        }

        return docSearch;
    }

    private void readFile(String file) {
        try ( Scanner read = new Scanner(new File(file))) {
            while (read.hasNextLine()) {
                String[] fields = read.nextLine().split(", ");
                doctors.put(fields[0], new Doctor(fields[0], fields[1], fields[2], Integer.parseInt(fields[3])));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
