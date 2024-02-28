/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.ShapeController;
import utils.Library;

public class ShapeView extends Menu {

    private Library library;
    private ShapeController shapeController;

    public ShapeView() {
        super("Calculate perimeter and area", new String[]{"Press 1 to start", "Exit"});
        library = new Library();
        shapeController = new ShapeController();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                double f1 = library.getDouble("Please input side width of Rectangle");
                double f2 = library.getDouble("Please input length  of Rectangle");
                double f3 = library.getDouble("Please input radius of Circle");
                double f4 = library.getDouble("Please input side A of Triangle");
                double f5 = library.getDouble("Please input side B of Triangle");
                double f6 = library.getDouble("Please input side C of Triangle");
                shapeController.calcRectangle(f1, f2);
                shapeController.calcCircle(f3);
                shapeController.calcTriangle(f4, f5, f6);
                break;
            case 2: 
                exitMenu();
        }
    }

}
