package com.example.kyc.controller;

import com.example.kyc.service.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aadhaar")
public class AadhaarController {

    @Autowired
    private AadhaarService aadhaarService;

    // Add Aadhaar and associated data
    @PostMapping("/add")
    public String addAadhaar(@RequestParam String userId, @RequestParam String aadhaarNumber) {
        return aadhaarService.createCustomerWithAadhaar(userId, aadhaarNumber);
    }
}
