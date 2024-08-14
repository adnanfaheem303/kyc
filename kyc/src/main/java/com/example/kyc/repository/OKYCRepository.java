package com.example.kyc.repository;

import com.example.kyc.entity.OKYC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OKYCRepository extends JpaRepository<OKYC, String> {
    Optional<OKYC> findByLastFourDigitsOfAadhaar(String lastFourDigits);
}
