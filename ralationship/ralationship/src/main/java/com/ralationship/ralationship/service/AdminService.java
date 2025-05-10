package com.ralationship.ralationship.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ralationship.ralationship.dto.AdminDTO;
import com.ralationship.ralationship.mapper.AdminMapper;
import com.ralationship.ralationship.model.Admin;
import com.ralationship.ralationship.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminDTO createAdmin(AdminDTO adminDTO){
        Optional<Admin> optionalAdmin = adminRepository.findByName(adminDTO.getName());
        if (optionalAdmin.isPresent()) {
            throw new RuntimeException();
        }
        Admin admin = AdminMapper.toEntity(adminDTO);
        Admin save = adminRepository.save(admin);
        return AdminMapper.toDto(save);
    }
    public List<AdminDTO> getAllAdmin(){
        return adminRepository.findAll()
            .stream()
            .map(AdminMapper::toDto)
            .collect(Collectors.toList());
    }
}
