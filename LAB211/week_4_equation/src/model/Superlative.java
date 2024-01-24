/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Superlative extends Equation {

    public Superlative(double a, double b) {
        super(a, b);
    }

    public double solve() {
        double x;
        x = -b / a;
        return x;
    }

    @Override
    public double[] findOdd() {
        double[] arr = new double[]{0, 0};

         if (isOddNumber(a)) {
            arr[0] = a;
        }
        if (isOddNumber(b)) {
            arr[1] = b;
        }
        
        return arr;
    }
    
      @Override
    public double[] findEven() {
        double[] arr = new double[2];

         if (isEvenNumber(a)) {
            arr[0] = a;
        }
        if (isEvenNumber(b)) {
            arr[1] = b;
        }
        
        return arr;
    }
    
    

    @Override
    public int[] findPerfectSquare() {
          int[] arr = new int[2];
        if (isPerfectSquare(a)) {
            arr[0] = (int)a;
        }
        if (isPerfectSquare(b)) {
            arr[1] = (int)b;
        }
        return arr;
    }

}
