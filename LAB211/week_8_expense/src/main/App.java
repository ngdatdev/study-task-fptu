/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.ExpenseController;
import model.ExpenseList;
import view.ExpenseView;

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        new ExpenseView(new ExpenseController(new ExpenseList())).run();
    }
}
