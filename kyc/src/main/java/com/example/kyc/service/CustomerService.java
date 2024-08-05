package com.example.kyc.service;

import com.example.kyc.Customer;
import com.example.kyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(String fullAadhaarNumber) {
        Customer customer = new Customer();
        customer.setFullAadhaarNumber(fullAadhaarNumber);
        customer.setLast4Digits(fullAadhaarNumber.substring(fullAadhaarNumber.length() - 4));
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByLast4Digits(String last4Digits) {
        return customerRepository.findByLast4Digits(last4Digits);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
