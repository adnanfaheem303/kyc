package com.example.kyc.dto;

public class KYCVerificationDTO {
    private String aadhaarNumber;
    private String kycType; // CKYC, DigiLocker, OKYC

    // Getters and Setters
    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getKycType() {
        return kycType;
    }

    public void setKycType(String kycType) {
        this.kycType = kycType;
    }
}
