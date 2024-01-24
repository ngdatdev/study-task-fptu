/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithm;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Input {

    private static Scanner sc = new Scanner(System.in);
   

    public static int getInt(String ms) {
        System.out.print(ms);
        return sc.nextInt();
    }

}
