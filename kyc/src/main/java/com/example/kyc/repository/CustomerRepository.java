package com.example.kyc.repository;


import com.example.kyc.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByUserId(String userId);
    Customer findByLastFourDigitsOfAadhaar(String lastFourDigitsOfAadhaar);
}