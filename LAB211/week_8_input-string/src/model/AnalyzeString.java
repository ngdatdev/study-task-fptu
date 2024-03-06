/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author admin
 */
public class AnalyzeString {

    private String input;

    public AnalyzeString() {
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }

    public HashMap<String, List<Integer>> getNumberAnalysis() {
        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> squareNumbers = new ArrayList<>();

        String[] tokens = input.split("\\D+"); 
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);
                allNumbers.add(num);
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }
                if ((int)Math.sqrt(num) - Math.sqrt(num) == 0) {
                   squareNumbers.add(num);
                }
            }
        }
        result.put("allNumbers", allNumbers);
        result.put("evenNumbers", evenNumbers);
        result.put("oddNumbers", oddNumbers);
        result.put("squareNumbers", squareNumbers);

        return result;
    }

    public HashMap<String, StringBuilder> getCharacterAnalysis() {
        HashMap<String, StringBuilder> result = new HashMap<>();
        StringBuilder allCharacters = new StringBuilder();
        StringBuilder uppercaseCharacters = new StringBuilder();
        StringBuilder lowercaseCharacters = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();

        for (char c : input.toCharArray()) {
            allCharacters.append(c);
            if (Character.isUpperCase(c)) {
                uppercaseCharacters.append(c);
            } else if (Character.isLowerCase(c)) {
                lowercaseCharacters.append(c);
            } else if (!Character.isWhitespace(c) && !Character.isDigit(c)) {
                specialCharacters.append(c);
            }
        }

        result.put("allCharacters", allCharacters);
        result.put("uppercaseCharacters", uppercaseCharacters);
        result.put("lowercaseCharacters", lowercaseCharacters);
        result.put("specialCharacters", specialCharacters);

        return result;
    }
    
    public static void main(String[] args) {
        String[] tokens = "123abc2".split("\\D+");
        for(String token : tokens) {
            System.out.println(token);
        }
        int num = 9;
        System.out.println((int)Math.sqrt(num) - Math.sqrt(num) == 0);
    }

}
