package com.example.kyc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CKYC {
    @Id
    private String userId;
    private String lastFourDigitsOfAadhaar;
    private String aadhaar;

    // Getter for userId
    public String getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter for lastFourDigitsOfAadhaar
    public String getLastFourDigitsOfAadhaar() {
        return lastFourDigitsOfAadhaar;
    }

    // Setter for lastFourDigitsOfAadhaar
    public void setLastFourDigitsOfAadhaar(String lastFourDigitsOfAadhaar) {
        this.lastFourDigitsOfAadhaar = lastFourDigitsOfAadhaar;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }
}
