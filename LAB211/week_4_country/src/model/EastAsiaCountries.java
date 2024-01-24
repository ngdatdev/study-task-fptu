/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-15s%-15s%-15.1f%-15s%n", getCountryCode(), getCountryName(), getTotalArea(), countryTerrain);
    }
}
