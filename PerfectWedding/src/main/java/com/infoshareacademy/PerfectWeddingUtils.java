package com.infoshareacademy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        Integer toReturn = 0;
        boolean exit = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextInt();
                if (toReturn < min || toReturn > max) {
                    throw new Exception();
                }
                exit = true;
            } catch (Exception e) {
                exit = false;
                System.out.println("nieodpowiedia wartosc.\n" + prompt);
            }
        } while (!exit);
        return toReturn;
    }

    public static Boolean returnTrueOrFalse(String prompt, String trueForThisString, String falseForThisString) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        Boolean condition = false;
        String scannerInput = "null";

        while (!(scannerInput.equals(trueForThisString) || scannerInput.equals(falseForThisString))) {
            try {
                System.out.println("Podaj " + trueForThisString + " lub " + falseForThisString);
                scannerInput = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Podaj " + trueForThisString + " lub " + falseForThisString);
            }
        }

        if (scannerInput.equals(trueForThisString)) {
            condition = true;
        } else {
            condition = false;
        }
        return condition;

    }

    public static LocalDate scanInputDate(String prompt, String exitCode, LocalDate exitMessage) {
        System.out.println(prompt+"Aby wyjsc nacisnij '"+exitCode+"'");
        LocalDate toReturn = null;
        boolean exit = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String dataToParse = scanner.nextLine();
                if(dataToParse.equals(exitCode)){
                    toReturn=exitMessage;
                    exit=true;
                }
                else {
                    toReturn = LocalDate.parse(dataToParse, DateTimeFormatter.ISO_LOCAL_DATE);
                    exit = true;
                }
            } catch (Exception e) {
                exit = false;
                System.out.println("nieodpowiedia wartosc.\n" + prompt);
            }
        } while (!exit);
        return toReturn;
    }
}
