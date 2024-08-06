package com.example.kyc.service;

import com.example.kyc.Customer;
import com.example.kyc.dto.CustomerDTO;
import com.example.kyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create or update a customer
    public Customer saveCustomer(Customer customer) {
        customer.setUpdatedDate(LocalDateTime.now());
        if (customer.getId() == null) {
            customer.setCreatedDate(LocalDateTime.now());
        }
        return customerRepository.save(customer);
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Get a customer by user ID
    public Customer getCustomerByUserId(String userId) {
        return (customerRepository.findByUserId(userId));
    }

    // Get a customer by full Aadhaar number
    public Optional<Customer> getCustomerByFullAadhaarNumber(String fullAadhaarNumber) {
        return Optional.ofNullable(customerRepository.findByFullAadhaarNumber(fullAadhaarNumber));
    }

    // Get customers by last four digits of Aadhaar
    public List<Customer> getCustomersByLastFourDigitsOfAadhaar(String lastFourDigitsOfAadhaar) {
        return customerRepository.findByLastFourDigitsOfAadhaar(lastFourDigitsOfAadhaar);
    }

    // Get customers by KYC Deduplication Status
    public List<Customer> getCustomersByKycDedupStatus(Customer.KycDeduplicationStatus kycDedupStatus) {
        return customerRepository.findByKycDedupStatus(kycDedupStatus);
    }

    // Get customers by KYC Type
    public List<Customer> getCustomersByKycType(Customer.KycType kycType) {
        return customerRepository.findByKycType(kycType);
    }

    // Get customers by created date range
    public List<Customer> getCustomersByCreatedDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return customerRepository.findByCreatedDateBetween(startDate, endDate);
    }

    // Get customers by updated date range
    public List<Customer> getCustomersByUpdatedDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return customerRepository.findByUpdatedDateBetween(startDate, endDate);
    }

    // Delete a customer by ID
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    // Delete a customer by user ID
    public void deleteCustomerByUserId(String userId) {
        customerRepository.deleteByUserId(userId);
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return customerDTO;
    }

    public CustomerDTO updateCustomer(String userId, CustomerDTO customerDTO) {
        return customerDTO;
    }

    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    // Additional methods can be added as needed
}
