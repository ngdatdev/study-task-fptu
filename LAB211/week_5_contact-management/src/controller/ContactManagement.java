/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import model.ContactList;
import view.Menu;
import library.Library;
import model.Contact;

/**
 *
 * @author admin
 */
public class ContactManagement extends Menu {

    private ContactList cl;
    private Library library;

    public ContactManagement() {
        super("Contact management", new String[]{"Add a contact", "Display all contact", "Delete a contact", "Exit"});
        cl = new ContactList();
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addContact();
                break;
            case 2:
                displayAll();
                break;
            case 3:
                deleteById();
                break;
            case 4:
                exitMenu();
                break;

        }
    }

    public void addContact() {
        String name = library.getString("Enter name");
        String group = library.getString("Enter group");
        String address = library.getString("Enter address");
        String phone = library.getString("Enter phone");
        while (!library.isValidPhoneNumber(phone)) {
            System.out.println("Invalid phone number format. Please try again.");
            phone = library.getString("Enter phone");
        }
        cl.addContact(new Contact(0, name, group, address, phone));
        System.out.println("Successful");
    }

    public void displayAll() {
        if (cl.getContacts().isEmpty()) {
            System.out.println("Not have any contact");
        } else {
            System.out.println(String.format("%-3s %-20s %-12s %-12s %-5s %-10s %-12s",
            "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone"));
            for (Contact c : cl.getContacts()) {
                System.out.println(c.toString());
            }
        }
    }

    public void deleteById() {
        int id = library.getInt("Enter id to delete");
        if( cl.deleteContact(id)) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Not found this id");
        }
       
    }

}
