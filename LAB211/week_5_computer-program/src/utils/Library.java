/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import model.Operator;

public class Library {

    private Scanner sc = new Scanner(System.in);

    public String getString(String msg) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

    public int getInt(String msg) {
        int nInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String n = sc.nextLine();
                nInt = Integer.parseInt(n);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return nInt;
    }

    public double getDouble(String msg) {
        double nDouble = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String n = sc.nextLine();
                nDouble = Double.parseDouble(n);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
            }
        }
        return nDouble;
    }

    public String getOperator() {
        System.out.print("Enter Operator: ");
        String o = sc.nextLine();

        boolean isTrue = true;
        while (isTrue) {
            if (checkOperator(o)) {
                isTrue = false;
            } else {
                System.out.println("Please input (+, -, *, /, ^)");
                System.out.print("Enter Operator: ");
                o = sc.nextLine();
            }
        }
        return o;
    }

    public boolean checkOperator(String op) {
        for (Operator o : Operator.values()) {
            if (o.getSymbol().equals(op)) {
                return true;
            }
        }
        System.out.println("Operator is not valid");
        return false;
    }
}
