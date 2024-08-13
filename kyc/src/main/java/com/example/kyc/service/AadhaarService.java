package com.example.kyc.service;

import com.example.kyc.dto.AadhaarDTO;
import com.example.kyc.Customer;
import com.example.kyc.repository.AadhaarRepository;
import com.example.kyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AadhaarService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AadhaarRepository aadhaarRepository;

    // This method adds a record to the Customer table
    public void createCustomerRecord(AadhaarDTO aadhaarDTO) {
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

    // This method adds a record to the Aadhaar table
    public void createAadhaarRecord(AadhaarDTO aadhaarDTO) {
        com.example.kyc.entity.Aadhaar aadhaar = new com.example.kyc.entity.Aadhaar();
        aadhaar.setUserId(aadhaarDTO.getUserId());
        aadhaar.setAadhaarNumber(aadhaarDTO.getAadhaarNumber());
        aadhaarRepository.save(aadhaar);
    }

    // This method retrieves all records from the Aadhaar table
    public List<AadhaarDTO> getAllAadhaarRecords() {
        return aadhaarRepository.findAll()
                .stream()
                .map(aadhaar -> new AadhaarDTO(aadhaar.getUserId(), aadhaar.getAadhaarNumber()))
                .collect(Collectors.toList());
    }

    public void createRecord(AadhaarDTO aadhaarDTO) {
        // Create and save Aadhaar record
        com.example.kyc.entity.Aadhaar aadhaar = new com.example.kyc.entity.Aadhaar();
        aadhaar.setUserId(aadhaarDTO.getUserId());
        aadhaar.setAadhaarNumber(aadhaarDTO.getAadhaarNumber());
        aadhaarRepository.save(aadhaar);

        // Create and save Customer record (assuming the Customer table uses similar data)
        Customer customer = new Customer();
        customer.setUserId(aadhaarDTO.getUserId());
        customer.setFullAadhaarNumber(aadhaarDTO.getAadhaarNumber());
        customer.setLastFourDigitsOfAadhaar(aadhaarDTO.getAadhaarNumber().substring(aadhaarDTO.getAadhaarNumber().length() - 4));
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUpdatedDate(LocalDateTime.now());
        customer.setCreatedBy(aadhaarDTO.getUserId());
        customer.setUpdatedBy(aadhaarDTO.getUserId());
        customer.setKycDedupStatus(Customer.KycDeduplicationStatus.KYC_completed); // Default status
        customer.setKycType(Customer.KycType.CKYC); // Default type

        customerRepository.save(customer);
    }

    public List<AadhaarDTO> getAllRecords() {
        return aadhaarRepository.findAll()
                .stream()
                .map(aadhaar -> new AadhaarDTO(aadhaar.getUserId(), aadhaar.getAadhaarNumber()))
                .collect(Collectors.toList());
    }

}
