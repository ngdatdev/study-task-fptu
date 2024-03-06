/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.StringController;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class InputStringView extends Menu{

    private StringController stringController;
    
    public InputStringView() {
        super("Analysis String program", new String[] {"Input string", "Exit"});
        stringController = new StringController();
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                stringController.getAnalyzeString(input);
                break;
            case 2:
                exitMenu();
                break;
        }
    }

    
    
}
