/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.util.Scanner;
import java.util.regex.Pattern;

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

    public  boolean isValidPhoneNumber(String phone) {
        String regex = "^(\\d{10}|\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4})$";
        return Pattern.matches(regex, phone);
    }

}
