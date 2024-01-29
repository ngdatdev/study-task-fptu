/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class NormarCalculator {

    private double a;
    private double b;

    public NormarCalculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(double a, double b, String op) {
        Operator o = checkOperator(op);
        switch (o) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION: {
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("B can't get 0");
                }
            }
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
    }
    public Operator checkOperator(String o) {
        switch (o) {
            case "+":
                return Operator.ADDITION;
            case "-":
                return Operator.SUBTRACTION;
            case "*":
                return Operator.MULTIPLICATION;
            case "/":
                return Operator.DIVISION;
            case "^":
                return Operator.EXPONENT;
            case "=":
                return Operator.EQUAL;
            default:
                return null;
        }
    }
   
}
