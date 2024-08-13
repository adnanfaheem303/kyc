package com.example.kyc.repository;

import com.example.kyc.entity.CKYC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CKYCRepository extends JpaRepository<CKYC, String> {
}
