/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import library.Library;
import model.EastAsiaCountries;
import model.ListCountry;
import view.Menu;

/**
 *
 * @author admin
 */
public class ManageEastAsiaCountries extends Menu {

    private ListCountry listCountry;
    private Library library;

    public ManageEastAsiaCountries(ListCountry listCountry, Library library) {
        super("MENU", new String[]{"Input the information of 11 countries in East Asia", "Display the information of country you've just input",
            "Search the information of country by user-entered name", "Display the information of countries sorted name in ascending order",
            "Exit"});
        this.listCountry = listCountry;
        this.library = library;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                inputInformation();
                break;
            case 2:
                displayLastestInput();
                break;
            case 3:
                searchCountryByName();
                break;
            case 4:
                displayInfoByAscName();
                break;
            case 5:
                exitMenu();
                break;

        }
    }

    public void inputInformation() {
        String code = library.getString("Enter code of country");
        String name = library.getString("Enter name of country");
        float totalArea = library.getFloat("Enter total Area");
        String terrain = library.getString("Enter terrain of country");

        EastAsiaCountries e = new EastAsiaCountries(code, name, totalArea, terrain);
        if (listCountry.inputCountry(e)) {
            System.out.println("Add " + name + " successfully");
        } else {
            System.out.println(name + " is already exist!");
        }
    }

    public void displayLastestInput() {
        listCountry.getLatestCountry().display();
    }

    public void displayInfoByAscName() {
        for (EastAsiaCountries e : listCountry.getCountriesAsc()) {
            e.display();
        }
    }

    public void searchCountryByName() {
        String name = library.getString("Enter the name you want to search for");
        EastAsiaCountries e = listCountry.searchCountryByName((p) -> p.getCountryName().contains(name));
        if (e == null) {
            System.out.println("This name is not found");
        } else {
            e.display();
        }

    }

}
