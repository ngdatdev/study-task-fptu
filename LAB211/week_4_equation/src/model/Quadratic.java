/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;

/**
 *
 * @author admin
 */
public class Quadratic extends Equation {

    private double c;

    public Quadratic(double a, double b, double c) {
        super(a, b);
        this.c = c;
    }

    public double[] solve() {
        double x1, x2;
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return null;
        } else {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{x1, x2};
        }
    }

    // return element 012 equivalent with a, b, c
    // if 1 is odd, 2 is oven, 0 real number
    @Override
    public double[] findOdd() {
        double[] arr = new double[3];

        if (isOddNumber(a)) {
            arr[0] = a;
        }
        if (isOddNumber(b)) {
            arr[1] = b;
        }
        if (isOddNumber(c)) {
            arr[2] = c;
        }
        return arr;
    }
    
     @Override
    public double[] findEven() {
        double[] arr = new double[3];

        if (isEvenNumber(a)) {
            arr[0] = a;
        }
        if (isEvenNumber(b)) {
            arr[1] = b;
        }
        if (isEvenNumber(c)) {
            arr[2] = c;
        }
        return arr;
    }

    @Override
    public int[] findPerfectSquare() {
        int[] arr = new int[3];
        if (isPerfectSquare(a)) {
            arr[0] = (int)a;
        }
        if (isPerfectSquare(b)) {
            arr[1] =(int) b;
        }
        if (isPerfectSquare(c)) {
            arr[2] = (int)c;
        }
        
        return arr;
    }

    public static void main(String[] args) {
        Quadratic q = new Quadratic(1, -2, 3);
        System.out.println(Arrays.toString(q.findPerfectSquare()));
    }

}
