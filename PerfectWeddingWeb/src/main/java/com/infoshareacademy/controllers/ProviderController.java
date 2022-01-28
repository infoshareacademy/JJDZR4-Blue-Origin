package com.infoshareacademy.controllers;

import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceProviderDto;
import com.infoshareacademy.dto.ServiceSearchProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String addProvider(@Valid @ModelAttribute("serviceProviderAddDto") ServiceAddProviderDto serviceAddProviderDto,
                              BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "ProviderAdd";
        }
        serviceProviderService.addProvider(serviceAddProviderDto);
        return "redirect:/all-providers";
    }

    @GetMapping("providers/edit/{id}")
    @ResponseBody //TODO: usunac jak juz bedzie gotowa metoda
    public String editForm(Model model, @PathVariable Integer id) {

        model.addAttribute("serviceProviderAddDto", null);

        //toDO dodać po ID

        return "tu bedzie formatka edycji pojedynczego dostawcy";
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

    @GetMapping("/providers/edit")
    public String clientsPage(Model model) {
        model.addAttribute("cityAndTypeOfService", new ServiceSearchProviderDto());
        return "ProviderEditMenu";
    }

    @PostMapping("/providers/edit")
    public String findByTypeOfService(Model modelOfFoundProviders, /*@ModelAttribute("serviceSearchProviderDto")*/ ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders
                .addAttribute("providersByServiceTH", serviceProviderService.findProviders(serviceSearchProviderDto.getServiceType(), serviceSearchProviderDto.getCity(), serviceSearchProviderDto.getDate(), true))
                .addAttribute("ClientPanel", false);
        return "FoundProviders";
    }

}
