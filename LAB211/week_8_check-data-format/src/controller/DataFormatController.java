/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DataFormat;

public class DataFormatController {

    private DataFormat model;

    public DataFormatController() {
        model = new DataFormat();
    }

    public void validPhoneNumber(String phone) {
        String number = model.checkPhone(phone);
        if (number.equals("")) {
            System.out.println("OK");
        } else {
            System.err.println(number);
        }
    }

    public void validEmail(String email) {
        String mail = model.checkEmail(email);
        if (mail.equals("")) {
            System.out.println("OK");
        } else {
            System.err.println(mail);
        }
    }

    public void validDate(String date) {
        String dateFormat = model.checkDate(date);
        if (dateFormat.equals("")) {
            System.out.println("OK");
        } else {
            System.err.println(dateFormat);
        }
    }

}
