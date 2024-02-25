/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.DictionaryController;
import model.Dictionary;
import view.DictionaryView;

/**
 *
 * @author admin
 */
public class App {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryController dictionaryController = new DictionaryController(dictionary);
        
        new DictionaryView(dictionaryController).run();
    }
}
