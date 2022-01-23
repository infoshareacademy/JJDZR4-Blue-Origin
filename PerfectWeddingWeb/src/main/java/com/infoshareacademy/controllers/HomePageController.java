package com.infoshareacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("")
    public String mainPage() {
        return "HomePage";
    }

    @GetMapping("/providers")
    public String providersPage() {
        return "ProviderMenu";
    }

}
