package com.infoshareacademy;


public class App
{
    public static ProviderDataBase providerDataBase = new ProviderDataBase();
    public static void main( String[] args )
    {
        providerDataBase.readProviderListFromFile();
        System.out.println(providerDataBase);
        Menu menu = new Menu();
        menu.printWelcomeLogo();
        menu.mainMenu();
        providerDataBase.addProviderListToFile();
    }
}
