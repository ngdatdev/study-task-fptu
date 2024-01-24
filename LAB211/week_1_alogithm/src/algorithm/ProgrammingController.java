/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import java.util.Arrays;   

public class ProgrammingController extends Menu<String> {

    private final Algorithm algorithm;

    public ProgrammingController(int size) {
        super("Algorithm Programming", new String[]{"Sort", "Search", "Quit"});
        algorithm = new Algorithm(size);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                sorting();
                break;
            case 2:
                searching();
                break;
            case 3:
                exitMenu();
                break;
        }

    }

    public void sorting() {
        new Menu<String>("Sort programming", new String[]{"Bubble sort", "Quick sort", "Quit"}) {
            @Override
            public void execute(int n) {
                int[] arrays;
                switch (n) {
                    case 1:
                        System.out.println(Arrays.toString(algorithm.getArrays()));
                        arrays = algorithm.bubbleSort();
                        System.out.println(Arrays.toString(arrays));
                        break;
                    case 2:
                        System.out.println(Arrays.toString(algorithm.getArrays()));
                        arrays = algorithm.quickSort();
                        System.out.println(Arrays.toString(arrays));
                        break;
                    case 3:
                        exitMenu();
                        break;
                }
            }
        }.run();
    }
    
    public void searching() {
        new Menu<String>("Search programming", new String[]{"Linear search", "Binary search", "Quit"}) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.println(Arrays.toString(algorithm.bubbleSort()));
                        int key = Input.getInt("Enter the key: ");
                        System.out.println((algorithm.linearSearch(key) != -1) ? algorithm.linearSearch(key) : "Not found the key");
                        break;
                    case 2:
                        System.out.println(Arrays.toString(algorithm.quickSort()));
                        int key2 = Input.getInt("Enter the key: ");
                        System.out.println(algorithm.binarySearch(key2) != -1 ? algorithm.binarySearch(key2) : "Not found the key");
                        break;
                    case 3:
                        exitMenu();
                        break;
                }
            }
        }.run();
    }
}
