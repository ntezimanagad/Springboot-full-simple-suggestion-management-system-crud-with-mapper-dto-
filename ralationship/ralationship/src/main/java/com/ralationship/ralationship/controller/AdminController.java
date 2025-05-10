package com.ralationship.ralationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ralationship.ralationship.dto.AdminDTO;
import com.ralationship.ralationship.service.AdminService;

@RestController
@RequestMapping(value = "/api/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<AdminDTO>> getAllAdmin(){
        return ResponseEntity.ok(adminService.getAllAdmin());
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody AdminDTO AdminDTO){
        adminService.createAdmin(AdminDTO);
        return ResponseEntity.ok("created");
    }
}
