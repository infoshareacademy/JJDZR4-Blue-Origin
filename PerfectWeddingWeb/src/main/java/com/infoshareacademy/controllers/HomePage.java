package com.infoshareacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping("")
    public String mainPage() {
        return "HomePage";
    }

    @GetMapping("/clients")
    public String clientsPage() {
        return "ClientMenu";
    }

    @GetMapping("/providers")
    public String providersPage() {
        return "ProviderMenu";
    }

    @GetMapping("/showallproviders")
    public String showAllProviders() {

        return "jeszcze nic nie ma";
    }






}
