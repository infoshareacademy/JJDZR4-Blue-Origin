package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.domain.ServiceType;
import com.infoshareacademy.domain.TypesOfService;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public String showCreateForm(Model model) {
        model.addAttribute("serviceProviderAddDto", new ServiceAddProviderDto());
        return "ProviderAdd";
    }

    @PostMapping("providers/create")
    public String addProvider(@ModelAttribute("serviceProviderAddDto") ServiceAddProviderDto serviceAddProviderDto) throws IOException {
        serviceProviderService.addProvider(serviceAddProviderDto);
        return "redirect:/all-providers";
    }

    @GetMapping("providers/edit/{id}")
    public String editForm(Model model, @PathVariable Integer id) {

        model.addAttribute("serviceProviderAddDto", serviceProvider);

        //toDO dodać po ID

        return "ProviderAdd";
    }


    @ResponseBody
    public String clientsPage() {
        serviceProviderService.exportServiceProviders();

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
                .map(s -> serviceProviderMapper.mapperToDto(s))
                .collect(Collectors.toList());

        model.addAttribute("allProvidersTH", serviceProviderDtos);
        return "AllProviders";
    }

}
