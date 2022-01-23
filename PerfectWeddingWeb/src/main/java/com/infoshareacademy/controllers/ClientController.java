package com.infoshareacademy.controllers;

import com.infoshareacademy.dto.ServiceSearchProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ClientController {

    private ServiceProviderService serviceProviderService;
    private ServiceProviderMapper serviceProviderMapper;

    @Autowired
    public ClientController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
    }

    @GetMapping("/find-by-city")
    public String findByCity(Model model) {
        model.addAttribute("cityAndTypeOfService", new ServiceSearchProviderDto());
        return "ClientMenu";
    }

    @PostMapping("/find-by-city")
    public String findByCity(Model modelOfFoundProviders, @ModelAttribute("serviceSearchProviderDto") ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders.addAttribute("providersByCityTH", serviceProviderService.findByCity(serviceSearchProviderDto.getCity()));
        return "ProvidersByCity";
    }

    @PostMapping("/find-by-service")
    public String findByTypeOfService(Model modelOfFoundProviders, @ModelAttribute("serviceSearchProviderDto") ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders.addAttribute("providersByServiceTH", serviceProviderService.findTypeOfService(serviceSearchProviderDto.getServiceType()));
        return "ProvidersByService";
    }
}
