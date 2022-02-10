package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceEditProviderDto;
import com.infoshareacademy.dto.ServiceProviderDto;
import com.infoshareacademy.dto.ServiceSearchProviderDto;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
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
        return "redirect:/all-providers"; //toDO przed prezentacją zmienić na HomePage
    }


    @GetMapping("providers/edit/{id}")
    public String editForm(Model model, @PathVariable Integer id) {
        ServiceProvider serviceProvider = serviceProviderService.editById(id);
        ServiceEditProviderDto serviceEditProviderDto = serviceProviderMapper.mapToServiceEditProviderDto(serviceProvider);
        model.addAttribute("serviceEditProviderDto", serviceEditProviderDto);
        return "ProviderEditForm";
    }

    @PostMapping("providers/editById")
    public String editById(@Valid ServiceEditProviderDto serviceEditProviderDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "ProviderEditForm";
        }
        serviceProviderService.editProvider(serviceEditProviderDto);
        return "redirect:/all-providers";
    }

    @PostMapping("providers/addAvailabilityById")
    public String addAvailability(ServiceEditProviderDto serviceEditProviderDto) {
        serviceProviderService.addAvailabilityDateToProvider(serviceEditProviderDto.getAvailability().toString(), serviceEditProviderDto.getId());
        return "redirect:/all-providers";
    }


    @GetMapping("/deactivate/{id}")
    public String providersPageDeActivate(@PathVariable Integer id, Model model) {
        model.addAttribute("deActivatebyId", serviceProviderService.deActivate(id));
        return "redirect:/all-providers";
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
    public String findByTypeOfService(Model modelOfFoundProviders, ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders
                .addAttribute("providersByServiceTH", serviceProviderService.findProviders(serviceSearchProviderDto.getServiceType(), serviceSearchProviderDto.getCity(), serviceSearchProviderDto.getDate(), true))
                .addAttribute("toggleDeactivateEdit", false);
        return "FoundProviders";
    }


}
