package com.example.kyc.repository;

import com.example.kyc.entity.DigiLocker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DigiLockerRepository extends JpaRepository<DigiLocker, String> {
    Optional<DigiLocker> findByLastFourDigitsOfAadhaar(String lastFourDigits);
}
