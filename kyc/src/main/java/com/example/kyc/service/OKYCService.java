package com.example.kyc.service;

import com.example.kyc.entity.OKYC;
import com.example.kyc.repository.OKYCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OKYCService {

    @Autowired
    private OKYCRepository okycRepository;

    public OKYC saveOKYCRecord(OKYC oKYC) {
        // Extract the last 4 digits of the Aadhaar number
        String lastFourDigits = oKYC.getAadhaar().substring(oKYC.getAadhaar().length() - 4);
        oKYC.setLastFourDigitsOfAadhaar(lastFourDigits);

        // Save the record with only the last 4 digits of the Aadhaar number
        return okycRepository.save(oKYC);
    }

    public OKYC getOKYCRecord(String userId) {
        return okycRepository.findById(userId).orElse(null);
    }
}
