package com.example.kyc.repository;


import com.example.kyc.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByLast4Digits(String last4Digits);
}