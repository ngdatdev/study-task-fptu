/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Contact {

    private int id;
    private String name;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String star) {
        this.group = star;
    }

    public String getPhone() {
        return phone.replace(" ", "").replace("-", "");
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
    public Contact(int id, String name, String group,String address, String phone) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.address = address;
        this.phone = phone;
        setFirstLast();
    }

    public final void setFirstLast() {
        String word[] = name.split(" ");
        firstName = "";
        for (int i = 0; i < word.length; i++) {
            if (i == word.length - 1) {
                lastName = word[i];
            } else {
                firstName = firstName + word[i] + " ";
            }
        }
    }

    @Override
    public String toString() {
    return String.format("%-3d %-20s %-12s %-12s %-5s %-10s %-12s",
            id, name, getFirstName(), getLastName(), group, address, phone);
}

    
    
 

}
