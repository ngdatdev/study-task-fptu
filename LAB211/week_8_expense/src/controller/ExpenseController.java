/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Expense;
import model.ExpenseList;

/**
 *
 * @author admin
 */
public class ExpenseController {
    private ExpenseList expenseList;
    
    public ExpenseController(ExpenseList expenseList) {
        this.expenseList = expenseList;
    }
    
    public void addExpense(String date, double amount, String content) throws Exception {

        if(expenseList.addExpense(date, amount, content)) {
            System.out.println("Add successfully");
        } else {
            System.out.println("Failed Adding ");
        }
    }
    
    public void displayExpenses() {
        double totalAmount = 0;
        System.out.println(String.format("%-5s %-20s %-5s %-30s", "ID", "Date", "Amount", "Content"));
        for (Expense expense : expenseList.getExpenses()) {
            System.out.println(expense.toString());
            totalAmount += expense.getAmount();
        }
        System.out.println("Total: " + totalAmount);
    }
    
    public void removeExpense(int id) {
        expenseList.deleteExpense(id);
    }
}
