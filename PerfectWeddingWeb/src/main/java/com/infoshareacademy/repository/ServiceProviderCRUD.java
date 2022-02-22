package com.infoshareacademy.repository;

import com.infoshareacademy.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ServiceProviderCRUD extends JpaRepository<ServiceProvider, Integer> {

    List<ServiceProvider> findAll();

}