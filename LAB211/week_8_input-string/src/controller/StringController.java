/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.List;
import model.AnalyzeString;

/**
 *
 * @author admin
 */
public class StringController {

    private AnalyzeString analyzeString;

    public StringController() {
        analyzeString = new AnalyzeString();
    }

    public void getAnalyzeString(String input) {
        analyzeString.setInput(input);
        HashMap<String, List<Integer>> numberAnalysis = analyzeString.getNumberAnalysis();
        HashMap<String, StringBuilder> characterAnalysis = analyzeString.getCharacterAnalysis();

        // Display analysis results as needed
        System.out.println("Number Analysis:");
        System.out.println("Square numbers: " + numberAnalysis.get("squareNumbers"));
        System.out.println("Odd numbers: " + numberAnalysis.get("oddNumbers"));
        System.out.println("Even numbers: " + numberAnalysis.get("evenNumbers"));
        System.out.println("All numbers: " + numberAnalysis.get("allNumbers"));

        System.out.println("\nCharacter Analysis:");
        System.out.println("Uppercase characters: " + characterAnalysis.get("uppercaseCharacters"));
        System.out.println("Lowercase characters: " + characterAnalysis.get("lowercaseCharacters"));
        System.out.println("Special characters: " + characterAnalysis.get("specialCharacters"));
        System.out.println("All characters: " + characterAnalysis.get("allCharacters"));
    }
}
