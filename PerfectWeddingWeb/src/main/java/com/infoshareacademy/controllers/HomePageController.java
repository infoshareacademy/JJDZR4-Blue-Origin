package com.infoshareacademy.controllers;

import com.infoshareacademy.dto.ServiceSearchProviderDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/clients")
    public String clientsPage(Model model) {
        model.addAttribute("cityAndTypeOfService", new ServiceSearchProviderDto());
        return "ClientMenu";
    }

}
