package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.*;
import com.infoshareacademy.dto.ServiceProviderDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceProviderMapper {
    public ServiceProviderDto mapper (ServiceProvider serviceProvider) {
        ServiceProviderDto serviceProviderDto= new ServiceProviderDto();
        serviceProviderDto.setActive(serviceProvider.isActive());
        serviceProviderDto.setAvailability(serviceProvider.getAvailability());
        serviceProviderDto.setLocation(serviceProvider.getLocation());
        serviceProviderDto.setServiceType(serviceProvider.getServiceType());
        serviceProviderDto.setAverageRating(serviceProvider.getAverageRating());
        serviceProviderDto.setCompanyName(serviceProvider.getCompanyName());
        serviceProviderDto.setEmail(serviceProvider.getEmail());
        serviceProviderDto.setOwnerName(serviceProvider.getOwnerName());
        serviceProviderDto.setOwnerSurname(serviceProvider.getOwnerSurname());
        serviceProviderDto.setPhone(serviceProvider.getPhone());
        serviceProviderDto.setCurrentID(serviceProvider.getCurrentID());
        serviceProviderDto.setWebsiteAddress(serviceProvider.getWebsiteAddress());
        serviceProviderDto.setRatingList(serviceProvider.getRatingList());

        return serviceProviderDto;
    }
}
