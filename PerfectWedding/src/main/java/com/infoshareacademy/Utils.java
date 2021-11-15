package com.infoshareacademy;

import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.ServiceProvider;
import com.infoshareacademy.model.Voivodeship;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Utils {
    public static String scanInput(String prompt) {
        System.out.println(prompt);
        String toReturn = new String();
        try {
            Scanner scanner = new Scanner(System.in);
            toReturn = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("nieodpowiedia wartosc");
            toReturn = scanInput(prompt);
        }
        return toReturn;
    }

    public static Integer scanInput(String prompt, Integer min, Integer max) {
        System.out.println(prompt);
        Integer toReturn = 0;
//        boolean exit = false;
//
//        do {
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
//                exit = true;
        } catch (Exception e) {
//                exit = false;
            System.out.println("nieodpowiedia wartosc.\n" + prompt);
            toReturn=scanInput(prompt, min, max);
        }
//        } while (!exit);
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
//        boolean exit = false;
//
//        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String dataToParse = scanner.nextLine();
                if (dataToParse.equalsIgnoreCase(exitCode)) {
                    toReturn = exitMessage;
//                    exit = true;
                } else {
                    toReturn = LocalDate.parse(dataToParse, DateTimeFormatter.ISO_LOCAL_DATE);
//                    exit = true;
                }
            } catch (Exception e) {
//                exit = false;
                System.out.println("nieodpowiedia wartosc.\n" + prompt);
                toReturn=scanInputDate(prompt, exitCode, exitMessage);
            }
//        } while (!exit);
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


    public static List<Integer> scanForInt(String prompt, int min, int max, boolean singleSelection) {
        System.out.println(prompt);
        List<Integer> toReturn = new ArrayList<>();
        String[] fromScannerDelimited;
        String fromScanner;
//        do {
            try {
                Scanner scanner = new Scanner(System.in);
                fromScanner = scanner.nextLine();
                fromScannerDelimited = fromScanner.split(",");
                if (singleSelection && fromScannerDelimited.length > 1) {
                    throw new Exception("too many argumets entered");
                }
                for (int i = 0; i < fromScannerDelimited.length; i++) {
                    Integer answerInt = Integer.parseInt(fromScannerDelimited[i]);
                    if (answerInt >= min && answerInt <= max) {
                        toReturn.add(answerInt);
                    } else {
                        throw new Exception("out of specified range");
                    }
                }
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                toReturn=scanForInt(prompt, min, max, singleSelection);
            }
//        } while (toReturn.size() == 0);
        return toReturn;
    }

    public static String scanForString(String prompt) {
        System.out.println(prompt);
        String toReturn = "";
//        do {
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                toReturn=scanForString(prompt);
            }
//        } while (Objects.equals(toReturn, ""));
        return toReturn;
    }

    public static String scanForString(String prompt, String... allowedAnswers) {
        String toReturn = "";
//        do {
            System.out.println(prompt);
            System.out.println("Dopuszczalne wartosci to: ");
            System.out.println(Arrays.toString(allowedAnswers));
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextLine();
                boolean isAnswerCorrect = false;
                for (int i = 0; i < allowedAnswers.length; i++) {
                    if (toReturn.equals(allowedAnswers[i])) {
                        isAnswerCorrect = true;
                        break;
                    }
                }
                if (!isAnswerCorrect) {
                    throw new Exception("not in the list of allowed answers");
                }
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                toReturn = scanForString(prompt, allowedAnswers);
            }
//        } while (toReturn.equals(""));
        return toReturn;
    }

    public static <T> String arrayToString(T[] array, Boolean printSequenceNumbers) {
        String toReturn = "";
        for (int i = 0; i < array.length; i++) {
            if (printSequenceNumbers) {
                toReturn = toReturn + (i + 1) + "." + array[i] + "\n";
            } else {
                toReturn = toReturn + array[i] + "\n";
            }
        }
        return toReturn;
    }

    public static <T> String listToString(List<T> list, Boolean printSequenceNumbers) {
        String toReturn = "";
        for (int i = 0; i < list.size(); i++) {
            if (printSequenceNumbers) {
                toReturn = toReturn + (i + 1) + "." + list.get(i) + "\n";
            } else {
                toReturn = toReturn + list.get(i) + "\n";
            }
        }
        return toReturn;
    }
    public static void setVoivodeship(ServiceProvider serviceProvider) {
//        serviceProvider.setLocation(new Location(scanInput("Podaj lokalizcje firmy (miasto)")));
        List<Voivodeship> listOfVoivodeships = Arrays.asList(Voivodeship.values());
        System.out.println("Wybierz wojewodztwo z ponizszej list");
        System.out.println(Utils.listToString(listOfVoivodeships, true));
        serviceProvider.getLocation().setVoivodeship(listOfVoivodeships.get(Utils.scanForInt("Wybiez wojewodztwo od 1 do " + listOfVoivodeships.size(), 1, listOfVoivodeships.size(), true).get(0) - 1));
    }
    public static boolean isPhoneNumberValid(String s)
    {     Pattern p = Pattern.compile("^\\d{9}$");

        Matcher m = p.matcher(s);

        return (m.matches());
    }

    public static void setPhone(ServiceProvider serviceProvider) {
        String phoneNumber = "";
        do {
            phoneNumber=scanInput("Podaj nr telefonu (9 cyfr bez zera na poczatku)");
        } while (!isPhoneNumberValid(phoneNumber));
        ;
        serviceProvider.setPhone(phoneNumber);
    }
}
