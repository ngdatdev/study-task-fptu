/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_view;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import model.Fruit;
import model.Shopping;

/**
 *
 * @author admin
 */
public class ShoppingController extends Menu {

    private Shopping shop;
    private Library library;

    public ShoppingController() {
        super("Shop fruit", new String[]{"Create Fruit", "View Order", "Shopping(for buyer)", "Exit"});
        shop = new Shopping();
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createFruit();
                break;
            case 2:
                viewOrder();
                break;
            case 3:
                doShopping();
                break;
            case 4:
                exitMenu();

        }
    }

    public void createFruit() {
        String nameF = library.getString("Enter the name of fruit");
        double price = library.getDouble("Enter the price of fruit");
        int quantity = library.getInt("Enter the quantity");
        String origin = library.getString("Enter the origin");

        Fruit f = new Fruit(nameF, price, quantity, origin);
        shop.createFruits(f);
    }

    public void viewOrder() {
        Hashtable<String, ArrayList<Fruit>> order = shop.getViewOrderShop();
        Enumeration<String> customers = order.keys();

        while (customers.hasMoreElements()) {
            String customer = customers.nextElement();
            System.out.println("Customer: " + customer);
            List<Fruit> fs = order.get(customer);
            listOrder(fs);
        }
    }

    public void doShopping() {
        boolean isStop = true;
        ArrayList<Fruit> fruits = new ArrayList<>();
        while (isStop) {
            listFruits();
            int choice = library.getInt("Enter your item choice");
            Fruit f = shop.getSelectItem(choice);
            System.out.println("You selected: " + f.getFruitName());
            System.out.println(f);
            int quantity = library.getInt("Enter the quantity of item");
            if (choice <= 0 || choice > shop.getSizeFruits()) {
                System.out.println("Not found item with choice: " + choice);
                return;
            }
            if (shop.doQuantity(choice, quantity)) {
                fruits.add(f);
            } else {
                System.out.println("Not enough to buy");
            }
            String select = library.getString("Do you want to order now(Y/N)");
            if (select.equals("Y") || select.equals("y")) {
                isStop = false;
            }
        }

        String cus = library.getString("Enter the name of customer");

        shop.doShopping(cus, fruits);

    }

    private void listOrder(List<Fruit> fs) {
        double total = 0;
        for (Fruit f : fs) {
            total += f.getAmount();
            String productDetails = String.format(
                    "Product: %9s | Quantity: %d | Price: %.2f$ | Amount: %.2f$", f.getFruitName(),
                    f.getQuantity(), f.getPrice(), f.getAmount());
            System.out.println(productDetails);
        }
        System.out.println("Total: " + total + "$");
    }

    private void listFruits() {
        for (Fruit f : shop.getFruits()) {
            System.out.println(f);
        }
    }

}
