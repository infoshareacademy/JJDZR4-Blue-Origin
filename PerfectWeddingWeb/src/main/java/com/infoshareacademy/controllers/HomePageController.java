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

   /* @GetMapping("/clients")
    public String clientsPage() {
        return "ClientMenu";
    }
*/
   /* @GetMapping(value = "/findPlate")
    public String findByPlate(Model model) {
        model.addAttribute("searchPlate", new CarDto());
        return "repairCar";
    }

    @PostMapping(value = "/repTrue")
    public String changeBoolean(@ModelAttribute("searchPlate") CarDto carDto) {
        carsService.findByPlate(carDto.getPlateNumber());
        return "redirect:/allCarsRepaired";
    }*/

    @GetMapping("/find-by-city")
    public String findByCity(Model model) {
        model.addAttribute("cityAndTypeOfService", new ServiceSearchProviderDto());
        return "ClientMenu";
    }

    @PostMapping(value = "/find-by-city")
    public String findByCity(Model modelOfFoundProviders, @ModelAttribute("serviceSearchProviderDto") ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders.addAttribute("providersByCityTH", serviceProviderService.findByCity(serviceSearchProviderDto.getCity()));
        return "ProvidersByCity";
    }

    @GetMapping("/providers")
    public String providersPage() {
        return "ProviderMenu";
    }

}
