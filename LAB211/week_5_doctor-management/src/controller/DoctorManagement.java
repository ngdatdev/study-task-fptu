
package controller;

import library.Library;
import model.DoctorList;


public class DoctorManagement {


    public static void main(String[] args) {
        new DoctorController(new DoctorList(), new Library()).run();
    }
    
}
