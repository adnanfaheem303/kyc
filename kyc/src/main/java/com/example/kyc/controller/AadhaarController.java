package com.example.kyc.controller;

import com.example.kyc.dto.AadhaarDTO;
import com.example.kyc.service.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AadhaarController {

    @Autowired
    private AadhaarService aadhaarService;

    @PostMapping("/add-aadhaar")
    public ResponseEntity<String> addAadhaar(@RequestBody AadhaarDTO aadhaarDTO) {
        aadhaarService.createRecord(aadhaarDTO);
        return ResponseEntity.ok("Data added successfully!");
    }
}
