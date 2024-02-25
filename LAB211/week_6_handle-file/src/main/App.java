
package main;

import controller.FileController;
import model.FileHandle;
import view.FilePersonView;

public class App {
    public static void main(String[] args) {
        FileHandle fileHandle = new FileHandle();
        FileController fileController = new FileController(fileHandle);
        new FilePersonView(fileController).run();
    }
}
