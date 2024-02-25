/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author admin
 */
public class Node {
    Contact contact;
    Node left, right;
    int height;
    
    public Node(Contact contact) {
        this.contact = contact;
        height = 1;
    }
}
