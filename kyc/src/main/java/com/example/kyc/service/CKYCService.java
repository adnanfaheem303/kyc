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
        String fullAadhaar = ckyc.getAadhaar();
        String lastFourDigits = fullAadhaar.substring(fullAadhaar.length() - 4);
        ckyc.setLastFourDigitsOfAadhaar(lastFourDigits); // Save only the last 4 digits
        return ckycRepository.save(ckyc);
    }

    // Retrieving the CKYC record by user ID
    public CKYC getCKYCRecord(String userId) {
        return ckycRepository.findById(userId).orElse(null);
    }
}
