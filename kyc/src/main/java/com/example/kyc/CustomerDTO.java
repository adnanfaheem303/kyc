package com.example.kyc;

import java.time.LocalDateTime;

public class CustomerDTO {

    private Long id;
    private String userId;
    private String fullAadhaarNumber;
    private String lastFourDigitsOfAadhaar;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdBy;
    private String updatedBy;
    private String kycDedupStatus; // Use String here
    private String kycType; // Use String here

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
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
