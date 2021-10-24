package com.infoshareacademy;

import java.util.Scanner;

public class PerfectWeddingUtils {
    public static String scanInput(String prompt) {
        System.out.println(prompt);
        String toReturn = new String();
        try {
            Scanner scanner = new Scanner(System.in);
            toReturn = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("nieodpowiedia wartosc");
            scanInput(prompt);
        }
        return toReturn;
    }

    public static Integer scanInput(String prompt, Integer min, Integer max) {
        System.out.println(prompt);
        Integer toReturn = -2;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextInt();
                if (toReturn < min || toReturn > max) {
                    throw new Exception();
                }
            } catch (Exception e) {
                toReturn = -2;
                System.out.println("nieodpowiedia wartosc");
            }
        } while (toReturn == -2);
        return toReturn;
    }
}
