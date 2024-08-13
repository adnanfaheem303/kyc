package com.example.kyc.service;

import com.example.kyc.entity.OKYC;
import com.example.kyc.repository.OKYCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OKYCService {

    @Autowired
    private OKYCRepository okycRepository;

    public OKYC saveOKYCRecord(OKYC okyc) {
        return okycRepository.save(okyc);
    }

    public OKYC getOKYCRecord(String userId) {
        return okycRepository.findById(userId).orElse(null);
    }
}
