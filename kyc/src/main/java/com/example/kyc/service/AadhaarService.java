package com.example.kyc.service;

import com.example.kyc.Customer;
import com.example.kyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AadhaarService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save Aadhaar data for a customer
    public Customer saveAadhaarData(String userId, String fullAadhaarNumber, String createdBy, String updatedBy, Customer.KycDeduplicationStatus kycDedupStatus, Customer.KycType kycType) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerRepository.findByUserId(userId));
        Customer customer;

        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            customer = new Customer();
            customer.setUserId(userId);
            customer.setCreatedBy(createdBy);
            customer.setCreatedDate(LocalDateTime.now());
        }

        customer.setFullAadhaarNumber(fullAadhaarNumber);
        customer.setLastFourDigitsOfAadhaar(fullAadhaarNumber.substring(fullAadhaarNumber.length() - 4));
        customer.setUpdatedBy(updatedBy);
        customer.setUpdatedDate(LocalDateTime.now());
        customer.setKycDedupStatus(kycDedupStatus);
        customer.setKycType(kycType);

        return customerRepository.save(customer);
    }

    // Get Aadhaar data by user ID
    public Optional<Customer> getAadhaarDataByUserId(String userId) {
        return Optional.ofNullable(customerRepository.findByUserId(userId));
    }

    // Get Aadhaar data by full Aadhaar number
    public Optional<Customer> getAadhaarDataByFullAadhaarNumber(String fullAadhaarNumber) {
        return Optional.ofNullable(customerRepository.findByFullAadhaarNumber(fullAadhaarNumber));
    }

    // Get Aadhaar data by last four digits of Aadhaar
    public List<Customer> getAadhaarDataByLastFourDigitsOfAadhaar(String lastFourDigitsOfAadhaar) {
        return customerRepository.findByLastFourDigitsOfAadhaar(lastFourDigitsOfAadhaar);
    }

    public String createCustomerWithAadhaar(String userId, String aadhaarNumber) {
        return userId;
    }

    // Additional Aadhaar-related methods as needed
}
