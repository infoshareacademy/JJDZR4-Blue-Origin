package com.infoshareacademy;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    int response;

    public void mainMenu() {


        do {
            printMainMenu();
            try {
                response = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("");
                response = -1;
                scanner.nextLine();
            }

            switch (response) {
                case 0:
                    System.out.println("Czy na pewno wyjsc(T/N)?");
                    Scanner scanner1 = new Scanner(System.in);
                    String wantToQuit = scanner1.nextLine();
                    if (wantToQuit.toUpperCase().equals("T")) {
                        break;
                    } else response = -1;
                case 1:
                    clientMenu();
                    break;
                case 2:
                    providerMenu();
                    break;
                default:
                    System.out.println("wybiez opcje 0,1 lub 2");

                    break;
            }

        } while (response < 0 || response > 2);


    }

    private void printMainMenu() {
        System.out.println("Menu glowne");
        System.out.println("Wybierz opcje:");
        System.out.println("0. wyjscie z programu.");
        System.out.println("1. panel klienta");
        System.out.println("2. panel uslugodawcy");
    }

    private void printProviderMenu() {
        System.out.println("Menu usługodawcy");
        System.out.println("Wybierz opcje:");
        System.out.println("0. wyjscie z programu.");
        System.out.println("1. Załóż konto");
        System.out.println("2. Edytuj konto");
        System.out.println("3. Usuń konto");

    }

    private void clientMenu() {


    }

    private void deleteAccount() {

    }

    private void providerMenu() {
        ProvidersOperations providersOperations = new ProvidersOperations();
        do {
            printProviderMenu();
            try {
                response = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("");
                response = -1;
                scanner.nextLine();
            }

            switch (response) {
                case 0:
                    System.out.println("Czy na pewno wyjsc(T/N)?");
                    Scanner scanner1 = new Scanner(System.in);
                    String wantToQuit = scanner1.nextLine();
                    if (wantToQuit.toUpperCase().equals("T")) {
                        break;
                    } else response = -1;
                case 1:
                    providersOperations.createProvider();
                    break;
                case 2:
                    providersOperations.editProvider();
                    break;
                case 3:
                    providersOperations.deleteProvider();
                    break;
                default:
                    System.out.println("wybierz opcje:");

                    break;
            }

        } while (response < 0 || response > 2);

    }
}
