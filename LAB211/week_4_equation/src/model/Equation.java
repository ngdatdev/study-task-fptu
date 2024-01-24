/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public abstract class Equation {

    protected double a;
    protected double b;

    public Equation(double a, double b) {
        if (a == 0) {
            a = 1;
        } else {
            this.a = a;
        }
        this.b = b;
    }

    abstract public double[] findOdd();

    abstract public double[] findEven();

    abstract public int[] findPerfectSquare();

    public boolean isEvenNumber(double n) {
        return n % 2 == 0;
    }

    public boolean isOddNumber(double n) {
        return n % 2 != 0;
    }

    public boolean isPerfectSquare(double n) {
        int squareRoot = (int) Math.sqrt(n);
        return squareRoot * squareRoot == n;
    }
}
