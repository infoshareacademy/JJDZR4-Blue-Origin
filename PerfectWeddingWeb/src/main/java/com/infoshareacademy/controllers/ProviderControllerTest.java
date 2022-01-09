package com.infoshareacademy.controllers;

import com.infoshareacademy.repository.ServiceProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProviderControllerTest {

    private ServiceProviderRepo serviceProviderRepo;

    @Autowired
    public ProviderControllerTest(ServiceProviderRepo serviceProviderRepo) {
        this.serviceProviderRepo = serviceProviderRepo;
    }

    @RequestMapping(value = "/all-providers")
    public String showAllProviders(Model model) {
        model.addAttribute("allProvidersTH", serviceProviderRepo.getServiceProvidersList());
        return "AllProviders";
    }
}
