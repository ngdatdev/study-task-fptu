/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class DataFormat {
      public String checkPhone(String phone) {
        if (!phone.matches("\\d+")) {
            return "Phone number must be numbers";
        } else if (phone.length() != 10) {
            return "Phone number must contain 10 numbers";
        }
        return "";
    }

    public String checkEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            return "Email must be correct format";
        }
        return "";
    }

    public String checkDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         try {
            Date parsedDate = dateFormat.parse(date);
            return "";
        } catch (ParseException e) {
            return "Date must be in the correct format (dd/MM/yyyy)";
        }
    }
}
