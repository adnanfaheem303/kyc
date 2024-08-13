package com.example.kyc.service;

import com.example.kyc.entity.DigiLocker;
import com.example.kyc.repository.DigiLockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DigiLockerService {

    @Autowired
    private DigiLockerRepository digiLockerRepository;

    public DigiLocker saveDigiLockerRecord(DigiLocker digiLocker) {
        return digiLockerRepository.save(digiLocker);
    }

    public DigiLocker getDigiLockerRecord(String userId) {
        return digiLockerRepository.findById(userId).orElse(null);
    }
}
