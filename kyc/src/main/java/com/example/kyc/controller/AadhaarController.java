package com.example.kyc.controller;

import com.example.kyc.service.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AadhaarController {

    @Autowired
    private AadhaarService aadhaarService;

    @PostMapping("/add-aadhaar")
    public String addAadhaar(@RequestParam String aadhaarNumber) {
        aadhaarService.createTableAndInsertData(aadhaarNumber);
        return "Data added successfully!";
    }
}
