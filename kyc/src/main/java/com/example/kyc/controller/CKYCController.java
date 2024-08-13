package com.example.kyc.controller;

import com.example.kyc.entity.CKYC;
import com.example.kyc.service.CKYCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ckyc")
public class CKYCController {

    @Autowired
    private CKYCService ckycService;

    @PostMapping("/add")
    public ResponseEntity<CKYC> addCKYCRecord(@RequestBody CKYC ckyc) {
        return ResponseEntity.ok(ckycService.saveCKYCRecord(ckyc));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CKYC> getCKYCRecord(@PathVariable String userId) {
        CKYC ckyc = ckycService.getCKYCRecord(userId);
        return ckyc != null ? ResponseEntity.ok(ckyc) : ResponseEntity.notFound().build();
    }

}
