package com.example.kyc.controller;

import com.example.kyc.dto.AadhaarDTO;
import com.example.kyc.service.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AadhaarController {

    @Autowired
    private AadhaarService aadhaarService;

    @PostMapping("/add-aadhaar")
    public ResponseEntity<String> addAadhaar(@RequestBody List<AadhaarDTO> aadhaarDTOList) {
        for (AadhaarDTO aadhaarDTO : aadhaarDTOList) {
            aadhaarService.createRecord(aadhaarDTO);
        }
        return ResponseEntity.ok("Data added successfully!");
    }

    @GetMapping("/all-aadhaar")
    public ResponseEntity<List<AadhaarDTO>> getAllAadhaarRecords() {
        List<AadhaarDTO> aadhaarList = aadhaarService.getAllAadhaarRecords();
        return ResponseEntity.ok(aadhaarList);
    }
}
