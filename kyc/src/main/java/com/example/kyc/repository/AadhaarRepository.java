package com.example.kyc.repository;

import com.example.kyc.entity.Aadhaar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadhaarRepository extends JpaRepository<Aadhaar, Long> {
    // custom query methods to be added here
}