/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class ExpenseList {
    private List<Expense> expenses;
    
    public ExpenseList() {
        expenses = new ArrayList<>();
    }
    
    public boolean addExpense(String date, double amount, String content) throws Exception {

        int newId = expenses.size() + 1; 
        Expense newExpense = new Expense(newId, date, amount, content);
        return expenses.add(newExpense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
    
    public void deleteExpense(int id) {
        expenses.remove(id - 1);
//        for (Expense expense : expenses) {
//            if (expense.getId() == id) {
//                expenses.remove(expense);
//                return true;
//            }
//        }
//        return false;
    }
    
    
}
