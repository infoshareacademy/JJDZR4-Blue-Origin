package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.EmailRequestDto;
import com.infoshareacademy.dto.ServiceEditProviderDto;
import com.infoshareacademy.dto.ServiceSearchProviderDto;
import com.infoshareacademy.email.EmailServiceImpl;
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
    private EmailServiceImpl emailService;

    public ClientController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper, EmailServiceImpl emailService) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
        this.emailService = emailService;
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
    }

    @PostMapping("/sendEmail/{id}")
    public String sendEmail(@PathVariable Integer id, Model model) {
      return null;
    }

    @GetMapping("/sendEmail/{id}")
    public String createEmail(@PathVariable Integer id, Model model) {
        ServiceProvider serviceProvider = serviceProviderService.findById(id);
        ServiceEditProviderDto serviceEditProviderDto = serviceProviderMapper.mapToServiceEditProviderDto(serviceProvider);
                EmailRequestDto emailRequestDto= new EmailRequestDto();
        model.addAttribute("emailRequestDto", emailRequestDto);
        model.addAttribute("provider", serviceEditProviderDto);
        return "ProviderSendEmail";
    }
}
