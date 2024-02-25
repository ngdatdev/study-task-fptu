/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.FileController;
import utils.Library;

/**
 *
 * @author admin
 */
public class FilePersonView extends Menu<String> {

    private FileController fileController;
    private Library library;

    public FilePersonView(FileController fileController) {
        super("File processing", new String[]{"Find person info", "Copy Text to new file", "Exit"});
        this.fileController = fileController;
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String path = library.getString("Enter path");
                Float money = library.getFloat("Enter money");
                fileController.displayPersons(path, money);
                break;
            case 2:
                String src = library.getString("Enter source");
                String newFile = library.getString("Enter new file");
                fileController.copyData(src, newFile);
                break;
            case 3:
                exitMenu();
                break;

        }
    }

}
