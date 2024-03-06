/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.ExpenseController;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.Library;

/**
 *
 * @author admin
 */
public class ExpenseView extends Menu<Object> {

    private ExpenseController expenseController;
    private Library library;

    public ExpenseView(ExpenseController expenseController) {
        super("Handy Expense program", new String[]{"Add an expense", "Display all expenses", "Delete an expense", "Quit"});
        this.expenseController = expenseController;
        this.library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                System.out.println("-------- Add an expense--------");
                String date = library.getString("Date(dd-MM-yyyy)");
                double amount = library.getDouble("Amount");
                String content = library.getString("Content");
                 {
                    try {
                        expenseController.addExpense(date, amount, content);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                break;

            case 2:
                System.out.println("---------Display all expenses------------");
                expenseController.displayExpenses();
                break;
            case 3:
                System.out.println("--------Delete an expense------");
                int id = library.getInt("Id");
                expenseController.removeExpense(id);
                break;
            case 4:
                exitMenu();
                break;
        }
    }

}
