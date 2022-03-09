package com.infoshareacademy.controllers;

import com.infoshareacademy.dto.ServiceSearchProviderDto;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("")
    public String mainPage() {
        return "HomePage";
    }
    @Secured("ROLE_USER")
    @GetMapping("/providers")
    public String providersPage() {
        return "ProviderMenu";
    }
    @Secured("ROLE_USER")
    @GetMapping("/find")
    public String clientsPage(Model model) {
        model.addAttribute("cityAndTypeOfService", new ServiceSearchProviderDto());
        return "ClientMenu";
    }

}
