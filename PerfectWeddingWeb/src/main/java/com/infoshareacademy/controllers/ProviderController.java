package com.infoshareacademy.controllers;

import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProviderController {


    private ServiceProviderService serviceProviderService;

    @Autowired
    public ProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping("providers/create")

    public String mainPage() {
        return "ProviderAdd";
    }

    @GetMapping("providers/edit")
    @ResponseBody
    public String clientsPage() {
        return "tu bedzie froamtka do edycji uslugodawcy";
    }

    @GetMapping("providers/deactivate")
    @ResponseBody
    public String providersPage() {
        return "tu bedzie froamtka do dezaktywacji uslugodawcy";
    }

    @RequestMapping(value = "/all-providers")
    public String showAllProviders(Model model) {
        model.addAttribute("allProvidersTH", serviceProviderService.returnAllServiceProviders());
        return "AllProviders";
    }

}
