/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author admin
 */
public class ListCountry {

    private List<EastAsiaCountries> eastcountries;

    public ListCountry() {
        eastcountries = new ArrayList<>();
    }

    public boolean inputCountry(EastAsiaCountries eastAsiaCountries) {
        for (EastAsiaCountries e : eastcountries) {
            if (e.countryCode.equals(eastAsiaCountries.countryCode)) {
                return false;
            }
        }
        eastcountries.add(eastAsiaCountries);
        return true;
    }

    public EastAsiaCountries getLatestCountry() {
        return eastcountries.get(eastcountries.size() - 1);
    }

    public EastAsiaCountries searchCountryByName(Predicate<EastAsiaCountries> p) {
        for (EastAsiaCountries es : eastcountries) {
            if (p.test(es)) {
                return es;
            }
        }
        return null;
    }

    public List<EastAsiaCountries> getCountriesAsc() {
        List<EastAsiaCountries> eacs = new ArrayList<>(eastcountries);
        eacs.sort((c1, c2) -> {
            return c1.getCountryName().compareTo(c2.getCountryName());
        }
        );
        return eacs;
    }
}
