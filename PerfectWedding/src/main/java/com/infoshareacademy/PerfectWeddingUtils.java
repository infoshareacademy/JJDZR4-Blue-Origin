package com.infoshareacademy;

import com.infoshareacademy.model.ServiceProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
                } else {
                    if (toReturn == 0) {
                        toReturn = 0;
                    }
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
        System.out.println(prompt + "Aby wyjsc nacisnij '" + exitCode + "'");
        LocalDate toReturn = null;
        boolean exit = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String dataToParse = scanner.nextLine();
                if (dataToParse.equalsIgnoreCase(exitCode)) {
                    toReturn = exitMessage;
                    exit = true;
                } else {
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

    public static void printListOfProviders(List<ServiceProvider> providersList) {
        System.out.println("Aktualna lista usługodawców wygląda następująco: ");
        for (ServiceProvider n : providersList) {
            System.out.println("ID -> " + n.getCurrentID() + " || "
                    + " Nazwa firmy -> " + n.getCompanyName() + " || "
                    + " Imię i nazwisko właściciela -> " + n.getOwnerName() + " " + n.getOwnerSurname());
        }
    }

    public static int returnIndexOfProviderAppointedByProviderId(List<ServiceProvider> providersList, int id) {
        int indexOfServiceProvider = -1;
        for (ServiceProvider n : providersList) {
            if (n.getCurrentID() == id) {
                indexOfServiceProvider = providersList.indexOf(n);
            }
        }
        return indexOfServiceProvider;
    }

    public static void printWelcomeLogo() {
        System.out.println("  _____  ______ _____  ______ ______ _____ _______  __          ________ _____  _____ _____ _   _  _____ ");
        System.out.println("|  __ \\|  ____|  __ \\|  ____|  ____/ ____|__   __| \\ \\        / /  ____|  __ \\|  __ \\_   _| \\ | |/ ____|");
        System.out.println("| |__) | |__  | |__) | |__  | |__ | |       | |     \\ \\  /\\  / /| |__  | |  | | |  | || | |  \\| | |  __ ");
        System.out.println("|  ___/|  __| |  _  /|  __| |  __|| |       | |      \\ \\/  \\/ / |  __| | |  | | |  | || | | . ` | | |_ |");
        System.out.println("| |    | |____| | \\ \\| |    | |___| |____   | |       \\  /\\  /  | |____| |__| | |__| || |_| |\\  | |__| |");
        System.out.println("|_|    |______|_|  \\_\\_|    |______\\_____|  |_|        \\/  \\/   |______|_____/|_____/_____|_| \\_|\\_____|");
        System.out.println();
    }
}
