package com.example.kyc;

public class CustomerDTO {
    private String userId;
    private String fullAadhaarNumber;
    private String lastFourDigitsOfAadhaar;
    private String createdBy;
    private String updatedBy;
    private String kycDedupStatus;
    private String kycType;

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullAadhaarNumber() {
        return fullAadhaarNumber;
    }

    public void setFullAadhaarNumber(String fullAadhaarNumber) {
        this.fullAadhaarNumber = fullAadhaarNumber;
    }

    public String getLastFourDigitsOfAadhaar() {
        return lastFourDigitsOfAadhaar;
    }

    public void setLastFourDigitsOfAadhaar(String lastFourDigitsOfAadhaar) {
        this.lastFourDigitsOfAadhaar = lastFourDigitsOfAadhaar;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getKycDedupStatus() {
        return kycDedupStatus;
    }

    public void setKycDedupStatus(String kycDedupStatus) {
        this.kycDedupStatus = kycDedupStatus;
    }

    public String getKycType() {
        return kycType;
    }

    public void setKycType(String kycType) {
        this.kycType = kycType;
    }
}
