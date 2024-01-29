/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.BMICaculator;
import model.NormarCalculator;
import utils.Library;
import view.Menu;

/**
 *
 * @author admin
 */
public class ComputerController extends Menu {

    private Library library;
    private NormarCalculator normarCalculator;
    private BMICaculator bMICaculator;

    public ComputerController(Library library) {
        super("Computer program", new String[]{"Normal Calculator", "BMI Calculator", "Exit"});
        this.library = library;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                calcNormal();
                break;
            case 2:
                calcBMI();
                break;
            case 3:
                exitMenu();
                break;
        }
    }

    public void calcNormal() {
        double a = library.getDouble("Enter number a");
        String o = library.getOperator();
        while (!o.equals("=")) {
            
            double b = library.getDouble("Enter number b: ");
            normarCalculator = new NormarCalculator(a, b);
            double memory = normarCalculator.calculate(a, b, o);
            
            System.out.println("Memory: " + memory);
            a = memory;
            o = library.getOperator();
        }
        System.out.println("Result: " + a);
    }

    public void calcBMI() {
        double weight = library.getDouble("Enter Weight(kg)");
        double height = library.getDouble("Enter Height(cm)");
        bMICaculator = new BMICaculator(weight, height);
        System.out.println("BMI number: " + bMICaculator.getBMI());
        System.out.println("BMI Status: " + bMICaculator.calculateBMI());
    }

}
