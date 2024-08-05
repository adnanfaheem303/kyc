package com.example.kyc.service;

import com.example.kyc.Customer;
import com.example.kyc.CustomerDto;
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

    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setUserId(customerDto.getUserId());
        customer.setFullAadhaarNumber(customerDto.getFullAadhaarNumber());
        customer.setLastFourDigitsOfAadhaar(customerDto.getLastFourDigitsOfAadhaar());
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUpdatedDate(LocalDateTime.now());
        customer.setCreatedBy(customerDto.getCreatedBy());
        customer.setUpdatedBy(customerDto.getUpdatedBy());
        customer.setKycDedupStatus(customerDto.getKycDedupStatus());
        customer.setKycType(customerDto.getKycType());

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Long id, CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFullAadhaarNumber(customerDto.getFullAadhaarNumber());
            customer.setLastFourDigitsOfAadhaar(customerDto.getLastFourDigitsOfAadhaar());
            customer.setUpdatedDate(LocalDateTime.now());
            customer.setUpdatedBy(customerDto.getUpdatedBy());
            customer.setKycDedupStatus(customerDto.getKycDedupStatus());
            customer.setKycType(customerDto.getKycType());

            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer findByUserId(String userId) {
        return customerRepository.findByUserId(userId);
    }

    public Customer findByLastFourDigitsOfAadhaar(String lastFourDigitsOfAadhaar) {
        return customerRepository.findByLastFourDigitsOfAadhaar(lastFourDigitsOfAadhaar);
    }
}