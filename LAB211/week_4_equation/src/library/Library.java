/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Library {
    private final Scanner sc = new Scanner(System.in);

    public String getString(String msg) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

 public double getDouble(String msg) {
        double nInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String n = sc.nextLine();
                nInt = Double.parseDouble(n);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return nInt;
    }
}
