package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> words;

    public Dictionary() {
        words = new HashMap<>();
        readData();
    }

    public void addWord(String eng, String vi) {
        words.put(eng, vi);
        updateDatabase();
    }

    public boolean removeWord(String eng) {
        if (words.containsKey(eng)) {
            words.remove(eng);
            updateDatabase();
            return true;
        }
        return false;
    }

    public String translate(String eng) {
        return words.getOrDefault(eng, "Not found in dictionary");
    }

    private void updateDatabase() {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))) {
            for (String eng : words.keySet()) {
                String vi = words.get(eng);
                writer.write(eng + "," + vi);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating database.");
        }
    }
    
    private void readData() {
        words.put("Cat", "Con meo");
        words.put("Dog", "Con cho");
        words.put("Tiger", "Con ho");
        words.put("Ruler", "Cai thuoc");
    }
}
