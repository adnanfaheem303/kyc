package com.example.kyc.repository;

import com.example.kyc.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find by User ID
    Customer findByUserId(String userId);

    // Find by Full Aadhaar Number
    Customer findByFullAadhaarNumber(String fullAadhaarNumber);

    // Find by Last Four Digits of Aadhaar
    List<Customer> findByLastFourDigitsOfAadhaar(String lastFourDigitsOfAadhaar);

    // Find by KYC Deduplication Status
    List<Customer> findByKycDedupStatus(Customer.KycDeduplicationStatus kycDedupStatus);

    // Find by KYC Type
    List<Customer> findByKycType(Customer.KycType kycType);

    // Find by Created By
    List<Customer> findByCreatedBy(String createdBy);

    // Find by Updated By
    List<Customer> findByUpdatedBy(String updatedBy);

    // Find by Created Date
    List<Customer> findByCreatedDate(LocalDateTime createdDate);

    // Find by Updated Date
    List<Customer> findByUpdatedDate(LocalDateTime updatedDate);

    // Find by Created Date Range
    List<Customer> findByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find by Updated Date Range
    List<Customer> findByUpdatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Custom JPQL Query: Find all customers created by a specific user with a specific status
    @Query("SELECT c FROM Customer c WHERE c.createdBy = ?1 AND c.kycDedupStatus = ?2")
    List<Customer> findByCreatedByAndKycDedupStatus(String createdBy, Customer.KycDeduplicationStatus kycDedupStatus);

    // Custom JPQL Query: Find all customers with a specific KYC type created in a specific date range
    @Query("SELECT c FROM Customer c WHERE c.kycType = ?1 AND c.createdDate BETWEEN ?2 AND ?3")
    List<Customer> findByKycTypeAndCreatedDateBetween(Customer.KycType kycType, LocalDateTime startDate, LocalDateTime endDate);

    // Custom JPQL Query: Find all customers with a specific Aadhaar number and KYC type
    @Query("SELECT c FROM Customer c WHERE c.fullAadhaarNumber = ?1 AND c.kycType = ?2")
    List<Customer> findByFullAadhaarNumberAndKycType(String fullAadhaarNumber, Customer.KycType kycType);

    // Custom JPQL Query: Find all customers updated by a specific user with a specific status
    @Query("SELECT c FROM Customer c WHERE c.updatedBy = ?1 AND c.kycDedupStatus = ?2")
    List<Customer> findByUpdatedByAndKycDedupStatus(String updatedBy, Customer.KycDeduplicationStatus kycDedupStatus);

    // Custom JPQL Query: Find all customers with a specific last four digits of Aadhaar and KYC status
    @Query("SELECT c FROM Customer c WHERE c.lastFourDigitsOfAadhaar = ?1 AND c.kycDedupStatus = ?2")
    List<Customer> findByLastFourDigitsOfAadhaarAndKycDedupStatus(String lastFourDigitsOfAadhaar, Customer.KycDeduplicationStatus kycDedupStatus);

    // Custom JPQL Query: Find all customers by created date and updated date
    @Query("SELECT c FROM Customer c WHERE c.createdDate = ?1 AND c.updatedDate = ?2")
    List<Customer> findByCreatedDateAndUpdatedDate(LocalDateTime createdDate, LocalDateTime updatedDate);

    void deleteByUserId(String userId);
}
