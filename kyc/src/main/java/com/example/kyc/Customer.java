package com.example.kyc;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String fullAadhaarNumber;

    @Column(nullable = false)
    private String lastFourDigitsOfAadhaar;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String createdBy;

    private String updatedBy;

    @Enumerated(EnumType.STRING)
    private KycDeduplicationStatus kycDedupStatus;

    @Enumerated(EnumType.STRING)
    private KycType kycType;

    // Getters and setters

    // Enum for KYC Deduplication Status
    public enum KycDeduplicationStatus {

    }

    // Enum for KYC Type
    public enum KycType {

    }

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

    public KycDeduplicationStatus getKycDedupStatus() {
        return kycDedupStatus;
    }

    public void setKycDedupStatus(String kycDedupStatus) {
        this.kycDedupStatus = KycDeduplicationStatus.valueOf(kycDedupStatus);
    }

    public KycType getKycType() {
        return kycType;
    }

    public void setKycType(String kycType) {
        this.kycType = KycType.valueOf(kycType);
    }
}
