/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Arrays;
import library.Library;
import model.Quadratic;
import model.Superlative;
import view.Menu;

/**
 *
 * @author admin
 */
public class EquationController extends Menu {

    private Library library;

    public EquationController() {
        super("Solve equation", new String[]{"Solve superlative equation", "Solve quadratic equation", "Exit"});
        this.library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                calcSuperlativeEquation();
                break;
            case 2:
                calcQuadraticEquation();
                break;
            case 3:
                exitMenu();
                break;

        }
    }

    public void calcSuperlativeEquation() {
        double a = library.getDouble("Enter A");
        double b = library.getDouble("Enter B");

        Superlative e = new Superlative(a, b);
        double arr1[] = e.findOdd();
        double arr2[] = e.findEven();
        int arr3[] = e.findPerfectSquare();
        System.out.println("Solution: x = " + e.solve());
        System.out.println("Odd numbers: " + getNumberInLoop(arr1));
        System.out.println("Even numbers: " + getNumberInLoop(arr2));
        System.out.println("Perfect numbers: " + ((getPerfectNumbers(arr3) == null) ? 
                            "Not found" : getPerfectNumbers(arr3)));
    }

    public void calcQuadraticEquation() {
        double a = library.getDouble("Enter A");
        double b = library.getDouble("Enter B");
        double c = library.getDouble("Enter C");

        Quadratic q = new Quadratic(a, b, c);
        double arr[] = q.solve();
        double arr1[] = q.findOdd();
        double arr2[] = q.findEven();
        int arr3[] = q.findPerfectSquare();
        if (arr == null) {
            System.out.println("Not found x");
        } else {
            System.out.println("Solution: x1 = " + arr[0] + ", x2 = " + arr[1]);
        }
        System.out.println("Odd numbers: " + getNumberInLoop(arr1));
        System.out.println("Even numbers: " + getNumberInLoop(arr2));
        System.out.println("Perfect numbers: " + ((getPerfectNumbers(arr3) == null) ? "Not found" : getPerfectNumbers(arr3)));
    }

    public String getNumberInLoop(double[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(arr[i]).append(" ");
            }

        }
        return sb.toString();
    }

    public String getPerfectNumbers(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(arr[i]).append(" ");
            }

        }
        if (sb.toString().isEmpty()) {
            return null;
        }
        return sb.toString();
    }

}
