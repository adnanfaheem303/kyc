package com.example.kyc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullAadhaarNumber;
    private String last4Digits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullAadhaarNumber() {
        return fullAadhaarNumber;
    }

    public void setFullAadhaarNumber(String fullAadhaarNumber) {
        this.fullAadhaarNumber = fullAadhaarNumber;
    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }
}
