package com.example.kyc.controller;

import com.example.kyc.Customer;
import com.example.kyc.CustomerDTO;
import com.example.kyc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create a new customer
    @PostMapping("/add")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    // Get a customer by user ID
    @GetMapping("/{userId}")
    public Optional<Customer> getCustomerByUserId(@PathVariable String userId) {
        return customerService.getCustomerByUserId(userId);
    }

    // Update an existing customer
    @PutMapping("/{userId}")
    public CustomerDTO updateCustomer(@PathVariable String userId, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(userId, customerDTO);
    }

    // Delete a customer by user ID
    @DeleteMapping("/{userId}")
    public void deleteCustomer(@PathVariable String userId) {
        customerService.deleteCustomerByUserId(userId);
    }

    // Get all customers
    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Find customers by KYC Deduplication Status
    @GetMapping("/status/{status}")
    public List<Customer> getCustomersByKycDedupStatus(@PathVariable String status) {
        return customerService.getCustomersByKycDedupStatus(Customer.KycDeduplicationStatus.valueOf(status));
    }

    // Find customers by KYC Type
    @GetMapping("/type/{type}")
    public List<Customer> getCustomersByKycType(@PathVariable String type) {
        return customerService.getCustomersByKycType(Customer.KycType.valueOf(type));
    }

    // Find customers created within a date range
    @GetMapping("/created")
    public List<Customer> getCustomersByCreatedDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return customerService.getCustomersByCreatedDateRange(startDate, endDate);
    }

    // Find customers updated within a date range
    @GetMapping("/updated")
    public List<Customer> getCustomersByUpdatedDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return customerService.getCustomersByUpdatedDateRange(startDate, endDate);
    }
}
