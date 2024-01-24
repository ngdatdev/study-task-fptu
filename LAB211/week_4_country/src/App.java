
import controller.ManageEastAsiaCountries;
import library.Library;
import model.ListCountry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        new ManageEastAsiaCountries(new ListCountry(), new Library()).run();
    }
}
