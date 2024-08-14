package com.example.kyc.repository;

import com.example.kyc.entity.CKYC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CKYCRepository extends JpaRepository<CKYC, String> {
    Optional<CKYC> findByLastFourDigitsOfAadhaar(String lastFourDigits);
}
