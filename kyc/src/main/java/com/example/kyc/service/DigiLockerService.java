package com.example.kyc.service;

import com.example.kyc.entity.CKYC;
import com.example.kyc.entity.DigiLocker;
import com.example.kyc.repository.DigiLockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DigiLockerService {

    @Autowired
    private DigiLockerRepository digiLockerRepository;

    public DigiLocker saveDigiLockerRecord(DigiLocker digiLocker) {
        // Extract the last 4 digits of the Aadhaar number
        String lastFourDigits = digiLocker.getAadhaar().substring(digiLocker.getAadhaar().length() - 4);
        digiLocker.setLastFourDigitsOfAadhaar(lastFourDigits);

        // Save the record with only the last 4 digits of the Aadhaar number
        return digiLockerRepository.save(digiLocker);
    }

    public DigiLocker getDigiLockerRecord(String userId) {
        return digiLockerRepository.findById(userId).orElse(null);
    }
}
