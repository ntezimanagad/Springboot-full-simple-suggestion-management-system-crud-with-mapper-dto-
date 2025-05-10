package com.ralationship.ralationship.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ralationship.ralationship.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    Optional<Admin> findByName(String name);
}
