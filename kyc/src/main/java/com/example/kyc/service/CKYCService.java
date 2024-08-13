package com.example.kyc.service;

import com.example.kyc.entity.CKYC;
import com.example.kyc.repository.CKYCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CKYCService {

    @Autowired
    private CKYCRepository ckycRepository;

    public CKYC saveCKYCRecord(CKYC ckyc) {
        return ckycRepository.save(ckyc);
    }

    public CKYC getCKYCRecord(String userId) {
        return ckycRepository.findById(userId).orElse(null);
    }
}
