package com.infoshareacademy.repository;

import com.infoshareacademy.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;

public interface ServiceProviderCRUD extends JpaRepository<ServiceProvider, Integer> {

    List<ServiceProvider> findAll();

    @Query("select s from ServiceProvider s where s.location.city like ?1 and s.availability.dates in ?2")
    List<ServiceProvider> findAllByLocation_CityAndAvailability_Dates(String city, LocalDate availabilityDate);


}