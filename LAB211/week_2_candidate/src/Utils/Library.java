/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Scanner;
import model.Candidate;

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

    public Candidate getCandidate() {
        String fName, lName, bDate, address, phone, email;
        fName = getString("Enter first name");
        lName = getString("Enter last name");
        bDate = getString("Enter year of birth date");
        while(!validDateYear(bDate)) {
            bDate = getString("Enter year of birth date(ex: 2004)");
        }
        address = getString("Enter address");
        phone = getString("Enter phone");
        while(!validPhone(phone)) {
            phone = getString("Enter phone(format 10 digit)");
        }
        email = getString("Enter email");
        while(!validEmail(email)) {
            email = getString("Enter email(format <account name>@<domain>.<>)");
        }
        Candidate c = new Candidate(fName, lName, bDate, address, phone, email);
        return c;
    }

    public boolean validDateYear(String date) {
        return date.matches("\\d{4}");
    }
    
    public boolean validPhone(String phone) {
        return phone.matches("\\d{10}");
    }
    
    public boolean validEmail(String email) {
        return email.matches("^(.+)@(\\S+)\\.\\S+");
    }
    
    public boolean validYearOfExperience(String yearEx) {
        return yearEx.matches("[1-9][0-9]?|100");
    }
 
    public boolean validRank(String rank) {
        return rank.matches("(Excellence|Good|Fair|Poor)");
    }
    public static void main(String[] args) {
        Library l = new Library();
        System.out.println(l.validRank("0948379256"));
//        System.out.println("1234".matches("\\d{4}"));
    }
}
