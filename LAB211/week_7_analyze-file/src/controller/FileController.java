/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.FilePath;

/**
 *
 * @author admin
 */
public class FileController {
    private FilePath filePath;
    

    public void analyzeFilePath(String f) {
        filePath = new FilePath(f);
        System.out.println("----- Result Analysis -----");
        filePath.displayInfo();
    }
}
