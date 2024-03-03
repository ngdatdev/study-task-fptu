/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.FileController;
import model.FilePath;

/**
 *
 * @author admin
 */
public class FilePathView extends Menu {

    
    private FileController fileControloler;
    private Library library;
    
    public FilePathView(FileController fileControloler) {
        super("===== Analysis Path Program =====", new String[]{"Press 1 to analyze path", "Exit"});
        this.fileControloler = fileControloler;
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String filePath = library.getString("Please input Path");
                fileControloler.analyzeFilePath(filePath);
                break;
            case 2:
                exitMenu();
                break;
        }
    }

}
