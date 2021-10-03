package com.infoshareacademy;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        int response;

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
                    }else response = -1;
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
    private void printProviderMenu(){

    }

    private void clientMenu() {


    }

    private void providerMenu() {

    }
}
