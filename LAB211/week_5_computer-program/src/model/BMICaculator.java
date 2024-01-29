/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DecimalFormat;

/**
 *
 * @author admin
 */
public class BMICaculator {
    private double weight;
    private double height;
    
    public BMICaculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    
    public double getBMI() {
        double heightMeter = height / 100;
        double BMI = (weight / (heightMeter * heightMeter));
        DecimalFormat d = new DecimalFormat("#.#");
        String round = d.format(BMI);
        
        return Double.parseDouble(round);
    }
     
    public BMI calculateBMI() {
        double bmi = getBMI();
        if (bmi < 19) {
            return BMI.UNDER_STANDARD;
        } else if (bmi <= 25) {
            return BMI.STANDARD;
        } else if (bmi <= 30) {
            return BMI.OVERWEIGHT;
        } else if (bmi <= 40) {
            return BMI.FAT_SHOULD_LOSE_WEIGHT;
        } else {
            return BMI.VERY_FAT_SHOULD_LOSE_WEIGHT_IMMEDIATELY;
        }
    }
    
    
}
