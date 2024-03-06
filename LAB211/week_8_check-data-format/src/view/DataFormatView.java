/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.DataFormatController;
import library.Library;

/**
 *
 * @author admin
 */
public class DataFormatView extends Menu {

    private DataFormatController dataFormatController;
    private Library library;

    public DataFormatView() {
        super("Validate program", new String[] {"Phone number", "Email", "Date", "Exit"});
        dataFormatController = new DataFormatController();
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                String phone = library.getString("Enter number phone");
                dataFormatController.validPhoneNumber(phone);
                break;
            case 2:
                String email = library.getString("Enter email");
                dataFormatController.validEmail(email);
                break;
            case 3:
                String date = library.getString("Enter date");
                dataFormatController.validDate(date);
                break;
            case 4:
                exitMenu();
                break;
        }
    }

}
