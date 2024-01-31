/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int availability;
    
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return String.format("%-8s%-15s%-20s%-13d", code, name, specialization, availability);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    public String appending() {
        StringBuilder sb = new StringBuilder();
        
        return sb.append(code).append(name).append(specialization).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doctor other = (Doctor) obj;
        return Objects.equals(this.code, other.code);
    }
    
    
}
