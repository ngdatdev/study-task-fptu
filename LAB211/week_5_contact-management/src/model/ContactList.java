/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ContactList {
    private List<Contact> contacts;
    private int idCurrent;
    public ContactList() {
        contacts = new ArrayList<>();
    }
    
    public int increaseId() {
        return idCurrent += 1;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
    
    
    public void addContact(Contact c) {
        c.setId(increaseId());
        contacts.add(c);
    }
    
    public boolean deleteContact(int id) {
        for (Contact contact : contacts) {
            if(contact.getId() == id) {
                contacts.remove(contact);
                return true;
            }
        }
        return false;
    }
    
}
