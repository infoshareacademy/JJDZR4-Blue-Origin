package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.*;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Controller
public class ProviderController {

    private ServiceProviderService serviceProviderService;
    private ServiceProviderMapper serviceProviderMapper;

    @Autowired
    public ProviderController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
    }
    @Secured("ROLE_USER")
    @GetMapping("providers/create")
    public String showCreateForm(Model model) {
        model.addAttribute("serviceProviderAddDto", new ServiceAddProviderDto());
        return "ProviderAdd";
    }
    @Secured("ROLE_USER")
    @PostMapping("providers/create")
    public String addProvider(@Valid @ModelAttribute("serviceProviderAddDto") ServiceAddProviderDto serviceAddProviderDto,
                              BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "ProviderAdd";
        }
        serviceProviderService.addProvider(serviceAddProviderDto);
        return "redirect:/all-providers"; //toDO przed prezentacją zmienić na HomePage
    }

    @Secured("ROLE_USER")
    @GetMapping("providers/edit/{id}")
    public String editForm(Model model, @PathVariable Integer id) {
        ServiceProvider serviceProvider = serviceProviderService.findById(id);
        ServiceEditProviderDto serviceEditProviderDto = serviceProviderMapper.mapToServiceEditProviderDto(serviceProvider);
        List<LocalDate> providerAvailabilityDates = serviceProviderService.getProviderData(id - 1).getAvailability().getDates().stream().sorted().toList();
        List<ServiceProvider> providerToBeEdited = serviceProviderService.returnAllServiceProviders();
        model.addAttribute("serviceEditProviderDto", serviceEditProviderDto);
        model.addAttribute("providerToBeEditedAvailability", providerAvailabilityDates);
        model.addAttribute("allProviders", providerToBeEdited);
        return "ProviderEditForm";
    }
    @Secured("ROLE_USER")
    @PostMapping("providers/editById")
    public String editById(@Valid ServiceEditProviderDto serviceEditProviderDto,
                           BindingResult bindingResult,
                           Model model) throws IOException {
        List<LocalDate> providerAvailabilityDates = serviceProviderService.getProviderData(serviceEditProviderDto.getId() - 1).getAvailability().getDates().stream().sorted().toList();
        List<ServiceProvider> providerToBeEdited = serviceProviderService.returnAllServiceProviders();
        model.addAttribute("providerToBeEditedAvailability", providerAvailabilityDates);
        model.addAttribute("allProviders", providerToBeEdited);
        if (bindingResult.hasErrors()) {
            return "ProviderEditForm";
        }
        serviceProviderService.editProvider(serviceEditProviderDto);
        return "redirect:/all-providers";
    }
    @Secured("ROLE_USER")
    @PostMapping("providers/addAvailabilityById")
    public String addAvailability(ServiceEditProviderDto serviceEditProviderDto) {
        serviceProviderService.addAvailabilityDateToProvider(serviceEditProviderDto.getAvailability().toString(), serviceEditProviderDto.getId());
        int partOfUrl = serviceEditProviderDto.getId();
        return "redirect:edit/" + partOfUrl;
    }
    @Secured("ROLE_USER")
    @GetMapping(value = "/providers/remove/availability/{providerId}/{dateIndex}")
    public String removeAvailabilityFromProvider(@PathVariable int providerId, @PathVariable int dateIndex,
                                                 ServiceEditProviderDto serviceEditProviderDto) {
        serviceProviderService.removeAvailabilityDateFromProvider(providerId, dateIndex);
        int partOfUrl = serviceEditProviderDto.getId();
        return "redirect:/providers/edit/" + partOfUrl+1;
    }
    @Secured("ROLE_USER")
    @GetMapping("/deactivate/{id}")
    public String providersPageDeActivate(@PathVariable Integer id, Model model) {
        model.addAttribute("deActivatebyId", serviceProviderService.deActivate(id));
        return "redirect:/all-providers";
    }
    @Secured("ROLE_USER")
    @GetMapping(value = "/all-providers")
    public String showAllProviders(Model model) {

        final List<ServiceProviderDto> serviceProviderDtos = serviceProviderService.returnAllServiceProviders().stream()
                .map(s -> serviceProviderMapper.mapperToDto(s))
                .collect(Collectors.toList());

        model.addAttribute("allProvidersTH", serviceProviderDtos);
        return "AllProviders";
    }
    @Secured("ROLE_USER")
    @GetMapping("/providers/edit")
    public String clientsPage(Model model) {
        model.addAttribute("cityAndTypeOfService", new ServiceSearchProviderDto());
        return "ProviderEditMenu";
    }
    @Secured("ROLE_USER")
    @PostMapping("/providers/edit")
    public String findByTypeOfService(Model modelOfFoundProviders, ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders
                .addAttribute("providersByServiceTH", serviceProviderService.findProviders(serviceSearchProviderDto.getServiceType(), serviceSearchProviderDto.getCity(), serviceSearchProviderDto.getDate(), true))
                .addAttribute("toggleDeactivateEdit", false);
        return "FoundProviders";
    }

    @Secured("ROLE_USER")
    @GetMapping("providers/rate/{id}")
    public String rateForm(Model model, @PathVariable Integer id) {
        ServiceProvider serviceProvider = serviceProviderService.findById(id);
        RatingDto ratingDto = new RatingDto();
        ratingDto.setID(id);
        ratingDto.setCompanyName(serviceProvider.getCompanyName());
        model.addAttribute("ratingDto", ratingDto);
        return "ProviderRateForm";
    }
    @Secured("ROLE_USER")
    @PostMapping("providers/rateById")
    public String rateById(@Valid RatingDto ratingDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "ProviderRateForm";
        }
        serviceProviderService.addRatingToProvider(ratingDto);
        return "redirect:/all-providers";
    }
}
