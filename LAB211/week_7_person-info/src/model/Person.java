/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Person {

    private String name;
    private String address;
    private double salary;

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static Person inputPersonInfo(String name, String address, String sSalary) throws Exception {
        double salary;
        try {
            salary = Double.parseDouble(sSalary);
            if (salary <= 0) {
                throw new Exception("Salary must be a positive number.");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Salary must be a number.");
        }
        return new Person(name, address, salary);
    }
    
     public void displayPersonInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Salary: " + getSalary());
    }
}
