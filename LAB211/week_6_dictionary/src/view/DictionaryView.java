/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.DictionaryController;
import utils.Library;

/**
 *
 * @author admin
 */
public class DictionaryView extends Menu<String> {

    private DictionaryController dicController;
    private Library library;

    public DictionaryView(DictionaryController dicController) {
        super("============Dictionary Program=============",
                new String[]{"Add word", "Delete word", "Translate word", "Exit"});
        this.dicController = dicController;
        this.library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String eng = library.getString("Enter english");
                String vi = library.getString("Enter vietnamese");
                dicController.addWord(eng, vi);
                break;
            case 2:
                String eng2 = library.getString("Enter english");
                dicController.deleteWord(eng2);
                break;
            case 3:
                String eng3 = library.getString("Enter english");
                dicController.translateWord(eng3);
                break;
            case 4:
                exitMenu();
                break;
        }
    }

}
