package com.example.kyc.controller;

import com.example.kyc.Customer;
import com.example.kyc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody String fullAadhaarNumber) {
        return customerService.saveCustomer(fullAadhaarNumber);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/last4/{digits}")
    public Customer getCustomerByLast4Digits(@PathVariable String digits) {
        return customerService.getCustomerByLast4Digits(digits);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
