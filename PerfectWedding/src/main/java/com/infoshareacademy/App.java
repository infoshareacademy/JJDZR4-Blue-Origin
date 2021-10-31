package com.infoshareacademy;


public class App
{
    public static ProviderDataBase providerDataBase = new ProviderDataBase();
    public static void main( String[] args )
    {
        providerDataBase.readProviderListFromFile();
        Menu menu = new Menu();
        menu.mainMenu();
        providerDataBase.addProviderListToFile();
    }
}
