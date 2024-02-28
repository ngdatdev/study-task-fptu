/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;
/**
 *
 * @author admin
 */
public class ShapeController {
    
    public void calcRectangle(double a, double b) {
        Shape r = new Rectangle(a, b);
        r.getArea();
        r.getPerimeter();
        r.printResult();
    }
    
    public void calcCircle(double r) {
        Circle c = new Circle(r);
        c.getArea();
        c.getPerimeter();
        c.printResult();
    }
    
    public void calcTriangle(double a, double b, double c) {
        Triangle t = new Triangle(a, b, c);
        t.getArea();
        t.getPerimeter();
        t.printResult();
    }
    
    
}
