package com.infoshareacademy.controllers;

import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {


    private ServiceProviderService serviceProviderService;
    private ServiceProviderMapper serviceProviderMapper;

    @Autowired
    public HomePageController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
    }

    @GetMapping("")
    public String mainPage() {
        return "HomePage";
    }

    @GetMapping("/clients")
    public String clientsPage() {
        return "ClientMenu";
    }

    @GetMapping("/value/find-by-city/")
    public String findByCity(Model model, @RequestParam("searchCity") String city) {
        model.addAttribute("providersByCity", serviceProviderService.findByCity(city));
        return "ClientMenu";
    }

    @GetMapping("/providers")
    public String providersPage() {
        return "ProviderMenu";
    }

}
