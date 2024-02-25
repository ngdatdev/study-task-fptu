package controller;

import model.Dictionary;
import utils.Library;

public class DictionaryController {

    private Dictionary dictionary;
    private Library library;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
        library = new Library();
    }

    public void addWord(String eng, String vi) {


        dictionary.addWord(eng, vi);
        System.out.println("Add successfully");
    }

    public void deleteWord(String eng) {
        if(dictionary.removeWord(eng)) {
            System.out.println("Delete Successfully");
        } else {
            System.out.println("Not found with keyword: " + eng);
        }
    }
    
    public void translateWord(String eng) {
        System.out.print("Vietnamese: ");
        System.out.println(dictionary.translate(eng));
    }
    

    
}
