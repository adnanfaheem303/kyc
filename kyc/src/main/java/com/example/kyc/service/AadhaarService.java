package com.example.kyc.service;

import com.example.kyc.dto.AadhaarDTO;
import com.example.kyc.Customer;
import com.example.kyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AadhaarService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createRecord(AadhaarDTO aadhaarDTO) {
        Customer customer = new Customer();
        customer.setUserId(aadhaarDTO.getUserId());
        customer.setFullAadhaarNumber(aadhaarDTO.getAadhaarNumber());
        customer.setLastFourDigitsOfAadhaar(aadhaarDTO.getAadhaarNumber().substring(aadhaarDTO.getAadhaarNumber().length() - 4));
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUpdatedDate(LocalDateTime.now());
        customer.setCreatedBy(aadhaarDTO.getUserId()); // Assuming createdBy is the user ID
        customer.setUpdatedBy(aadhaarDTO.getUserId()); // Assuming updatedBy is the user ID
        customer.setKycDedupStatus(Customer.KycDeduplicationStatus.KYC_completed); // Default status
        customer.setKycType(Customer.KycType.CKYC); // Default type

        customerRepository.save(customer);
    }
}
