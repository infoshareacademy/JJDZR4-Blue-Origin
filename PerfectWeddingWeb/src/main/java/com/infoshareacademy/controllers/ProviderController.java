package com.infoshareacademy.controllers;

import com.infoshareacademy.dto.ServiceProviderDto;
import com.infoshareacademy.repository.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProviderController {

    @Autowired
    ServiceProvider serviceProvider;

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


    //Klasa ServceProvider w package repository jest wzorcem, ktorego nie powinnismy ruszac.
    //Jest ona odwzorowana w SeriveProviderDto, tkory jest w package dto. Obiekt tej klasy jest przekazywany w metodzie Post
    @PostMapping(value = "providers/addvalue")
    @ResponseBody
    public String create(ServiceProviderDto serviceProviderDto) {
        serviceProvider.setCompanyName(serviceProviderDto.getCompanyName());
        serviceProvider.setOwnerName(serviceProviderDto.getOwnerName());
        return serviceProvider.toString();
    }





}
