package com.example.kyc.dto;

public class AadhaarDTO {
    private String userId;
    private String aadhaarNumber;

    public AadhaarDTO(String userId, String aadhaarNumber) {
        this.userId = userId;
        this.aadhaarNumber = aadhaarNumber;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }
}
