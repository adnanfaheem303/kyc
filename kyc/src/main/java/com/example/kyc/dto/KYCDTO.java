package com.example.kyc.dto;

import java.sql.Timestamp;
import java.util.Objects;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "aadhaar_KYC")
public class KYCDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @GeneratedValue
    private Integer id;

    @Column(name = "customer_id", unique = true, nullable = false)
    private Long customerId;

    @Column(name = "aadhar_no", unique = true, nullable = false)
    private Long aadhar_no;
    @Column(name = "aadhar_last_four", unique = true, nullable = false)
    private Long aadhar_last_four;
    @Column(name = "KYC_type")
    private String KYC_type;
    @Column(name = "KYC_dedup_status")
    private String KYC_dedup_status;




    @Column(name="created_date")
    private Timestamp createdDate;

    @Column(name="updated_date")
    private Timestamp updatedDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;
}




//public Long getCustomerId() {
//    return customerId;
//}
//
//public void setCustomerId(Long customerId) {
//    this.customerId = customerId;
//}
//public Long getUserId() {
//    return userId;
//}
//public void setUserId(Long userId) {
//    this.userId = userId;
//}
//
//public Timestamp getCreatedDate() {
//    return createdDate;
//}
//public Timestamp getUpdatedDate() {
//    return updatedDate;
//}
//public void setCreatedDate(Timestamp createdDate) {
//    this.createdDate = createdDate;
//}
//public void setUpdatedDate(Timestamp updatedDate) {
//    this.updatedDate = updatedDate;
//}
//
//public Long getUpdatedBy() {
//    return updatedBy;
//}
//
//public void setUpdatedBy(Long updatedBy) {
//    this.updatedBy = updatedBy;
//}


