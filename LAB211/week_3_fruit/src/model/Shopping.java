/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Shopping {

    private FruitList fruitList;
    private Hashtable<String, ArrayList<Fruit>> shops;

    public Shopping() {
        shops = new Hashtable<>();
        fruitList = new FruitList();
    }

    public List<Fruit> getFruits() {
        return fruitList.getFruits();
    }

    public Hashtable<String, ArrayList<Fruit>> getViewOrderShop() {
        return shops;
    }

    public int getSizeFruits() {
        return getFruits().size();
    }

    public void createFruits(Fruit f) {
        int i = getFruits().size() + 1;
        f.setId(i);
        getFruits().add(f);
    }

    public void doShopping(String cusName, ArrayList<Fruit> fs) {
        shops.put(cusName, fs);
    }

    public boolean doQuantity(int choice, int quantity) {
        Fruit f = getSelectItem(choice);
        if (f.getQuantity() - quantity < 0) {
            return false;
        }
        fruitList.getFruits().set(choice - 1, new Fruit(f.getId(), f.getFruitName(), f.getPrice(), f.getQuantity() - quantity, f.getOrigin()));
        return true;
    }

    public Fruit getSelectItem(int choice) {
        return fruitList.getFruits().get(choice - 1);
    }

//    public static void main(String[] args) {
//        Shopping s = new Shopping();
////        s.listFruits(); 
//        s.doShopping(1, 2, "dat");
//        s.doShopping(2, 3, "Hat");
//        s.createFruits(new Fruit(4, "Dua leo", 0, 1, "Japanese"));
//        s.doShopping(4, 3, "Huy");
//        s.viewOrder();
//    }
}
