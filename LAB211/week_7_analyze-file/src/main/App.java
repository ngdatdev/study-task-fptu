/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.FileController;
import view.FilePathView;

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        new FilePathView(new FileController()).run();
    }
}
