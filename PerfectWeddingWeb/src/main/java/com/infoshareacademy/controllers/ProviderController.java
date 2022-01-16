package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProviderController {

    private ServiceProviderService serviceProviderService;
    private ServiceProviderMapper serviceProviderMapper;

    @Autowired
    public ProviderController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
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

    @GetMapping(value = "/all-providers")
    public String showAllProviders(Model model) {

        final List<ServiceProviderDto> serviceProviderDtos = serviceProviderService.returnAllServiceProviders().stream()
                .map(s -> serviceProviderMapper.mapper(s))
                .collect(Collectors.toList());

        model.addAttribute("allProvidersTH",serviceProviderDtos );
        return "AllProviders";
    }

}
