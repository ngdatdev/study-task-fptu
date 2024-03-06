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
public class Expense {

    private int id;
    private Date date;
    private double amount;
    private String content;

    public Expense(int id, String date, double amount, String content) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date d = dateFormat.parse(date);
        this.id = id;
        this.date = d;
        this.amount = amount;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-5s %-30s", id, new SimpleDateFormat("dd/MM/yyyy").format(date), amount, content);
    }

}
