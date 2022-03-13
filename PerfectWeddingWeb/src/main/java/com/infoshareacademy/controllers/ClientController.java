package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceSearchProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ClientController {

    private ServiceProviderService serviceProviderService;
    private ServiceProviderMapper serviceProviderMapper;

    @Autowired
    public ClientController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
    }

    @PostMapping("/find")
    public String findByTypeOfService(Model modelOfFoundProviders, ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders
                .addAttribute("providersByServiceTH", serviceProviderService.findProviders(serviceSearchProviderDto.getServiceType(), serviceSearchProviderDto.getCity(), serviceSearchProviderDto.getDate(), true))
                .addAttribute("toggleDeactivateEdit", "rate");
        return "FoundProviders";
    }

    @GetMapping("/providers/rated/{id}")
    public String ratedProvider(Model model, @PathVariable Integer id) {
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        serviceProviderList.add(serviceProviderService.findById(id));
                    model
                .addAttribute("providersByServiceTH",serviceProviderList )
                .addAttribute("toggleDeactivateEdit", "rated");
        return "FoundProviders";
        //TODO: for some reason it requires logging. Why?
    }
}
