package com.example.kyc.service;

import com.example.kyc.dto.AadhaarDTO;
import com.example.kyc.Customer;
import com.example.kyc.dto.KYCVerificationDTO;
import com.example.kyc.entity.CKYC;
import com.example.kyc.entity.DigiLocker;
import com.example.kyc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AadhaarService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AadhaarRepository aadhaarRepository;

    @Autowired
    private CKYCRepository ckycRepository;

    @Autowired
    private DigiLockerRepository digiLockerRepository;

    @Autowired
    private OKYCRepository okycRepository;

    // This method adds a record to the Customer table
//    public void createCustomerRecord(AadhaarDTO aadhaarDTO) {
//        Customer customer = new Customer();
//        customer.setUserId(aadhaarDTO.getUserId());
//        customer.setFullAadhaarNumber(aadhaarDTO.getAadhaarNumber());
//        customer.setLastFourDigitsOfAadhaar(aadhaarDTO.getAadhaarNumber().substring(aadhaarDTO.getAadhaarNumber().length() - 4));
//        customer.setCreatedDate(LocalDateTime.now());
//        customer.setUpdatedDate(LocalDateTime.now());
//        customer.setCreatedBy(aadhaarDTO.getUserId()); // Assuming createdBy is the user ID
//        customer.setUpdatedBy(aadhaarDTO.getUserId()); // Assuming updatedBy is the user ID
//        customer.setKycDedupStatus(Customer.KycDeduplicationStatus.KYC_completed); // Default status
//        customer.setKycType(Customer.KycType.CKYC); // Default type
//
//        customerRepository.save(customer);
//    }

    // This method adds a record to the Aadhaar table
//    public void createAadhaarRecord(AadhaarDTO aadhaarDTO) {
//        com.example.kyc.entity.Aadhaar aadhaar = new com.example.kyc.entity.Aadhaar();
//        aadhaar.setUserId(aadhaarDTO.getUserId());
//        aadhaar.setAadhaarNumber(aadhaarDTO.getAadhaarNumber());
//        aadhaarRepository.save(aadhaar);
//    }

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

        // Create and save Customer record
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

//    public List<AadhaarDTO> getAllRecords() {
//        return aadhaarRepository.findAll()
//                .stream()
//                .map(aadhaar -> new AadhaarDTO(aadhaar.getUserId(), aadhaar.getAadhaarNumber()))
//                .collect(Collectors.toList());
//    }

    public boolean verifyKYC(KYCVerificationDTO verificationDTO) {
        // Extract the last four digits of the Aadhaar number
        String lastFourDigits = verificationDTO.getAadhaarNumber().substring(verificationDTO.getAadhaarNumber().length() - 4);

        Optional<?> customerRecord;

        // Fetch the stored record based on the KYC type
        switch (verificationDTO.getKycType()) {
            case "CKYC":
                customerRecord = ckycRepository.findByLastFourDigitsOfAadhaar(lastFourDigits);
                break;
            case "DigiLocker":
                customerRecord = digiLockerRepository.findByLastFourDigitsOfAadhaar(lastFourDigits);
                break;
            case "OKYC":
                customerRecord = okycRepository.findByLastFourDigitsOfAadhaar(lastFourDigits);
                break;
            default:
                throw new IllegalArgumentException("Invalid KYC method");
        }

        // Debug logs
        System.out.println("Received Aadhaar Number: " + verificationDTO.getAadhaarNumber());
        System.out.println("KYC Type: " + verificationDTO.getKycType());
        System.out.println("Last Four Digits: " + lastFourDigits);
        System.out.println("Customer Record Present: " + customerRecord.isPresent());

        // Check if a matching record is found
        if (customerRecord.isPresent()) {
            // Fetch the customer associated with the Aadhaar number
            Optional<Customer> customerOptional = Optional.ofNullable(customerRepository.findByFullAadhaarNumber(verificationDTO.getAadhaarNumber()));
            if (customerOptional.isPresent()) {
                Customer customer = customerOptional.get();
                customer.setKycType(Customer.KycType.valueOf(verificationDTO.getKycType()));
                customer.setKycDedupStatus(Customer.KycDeduplicationStatus.KYC_completed);
                customerRepository.save(customer);
                return true;
            } else {
                throw new IllegalArgumentException("Customer not found for the provided Aadhaar number");
            }
        } else {
            System.out.println("No matching record found for the last four digits");
            return false;
        }
    }
}