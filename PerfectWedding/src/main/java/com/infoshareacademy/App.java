package com.infoshareacademy;


public class App
{
    public static ProviderDataBase providerDataBase = new ProviderDataBase();
    public static void main( String[] args )
    {
        Menu menu = new Menu();
        menu.mainMenu();
        App.providerDataBase.addProviderListToFile();
    }
}
