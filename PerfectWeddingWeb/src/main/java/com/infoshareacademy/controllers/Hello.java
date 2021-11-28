package com.infoshareacademy.controllers;

import com.infoshareacademy.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Hello {

    @GetMapping("")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/clients")
    public String clientsPage() {
        return "panelKlienta";
    }

    @GetMapping("/providers")
    public String providersPage() {
        return "panelUslugodawcy";
    }





}
