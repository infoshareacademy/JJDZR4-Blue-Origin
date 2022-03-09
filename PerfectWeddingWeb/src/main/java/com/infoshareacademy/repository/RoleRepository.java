package com.infoshareacademy.repository;


import com.infoshareacademy.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}