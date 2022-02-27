package com.infoshareacademy.repository;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.domain.TypesOfService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;

public interface ServiceProviderCRUD extends JpaRepository<ServiceProvider, Integer> {

    List<ServiceProvider> findAll();

    @Query("select s from ServiceProvider s where s.location.city like ?1 and ?2 IN (select d from s.availability.dates d)")
    List<ServiceProvider> findAllByLocation_CityAndAvailability_Dates(String city, LocalDate availabilityDate);

    @Query("select s from ServiceProvider s where s.location.city = ?1")
    List<ServiceProvider> findAllByLocation_City(String city);

    @Query("select s from ServiceProvider s where ?1 in (select d from s.availability.dates d)")
    List<ServiceProvider> findAllByAvailability_Dates(LocalDate availabilityDate);

    @Query("select s from ServiceProvider s where s.serviceType.typesOfService = ?1 and s.location.city = ?2 and ?3 in (select d from s.availability.dates d)")
    List<ServiceProvider> findAllByServiceTypeAndLocation_CityAndAvailability_Dates(TypesOfService typesOfService, String city, LocalDate availabilityDate);


}