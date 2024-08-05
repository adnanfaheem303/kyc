package com.example.kyc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class AadhaarService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final AtomicLong userIdCounter = new AtomicLong(); // For generating unique IDs

    public Long createTableAndInsertData(String aadhaarNumber) {
        // Automatically generate a unique user ID
        Long userId = userIdCounter.incrementAndGet(); // Generate a new unique ID

        // Extract last 4 digits of Aadhaar number
        String last4Digits = aadhaarNumber.substring(aadhaarNumber.length() - 4);

        // Generate a unique table name based on userId
        String tableName = "user_" + userId;

        // SQL statement to create a new table
        String createTableSql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "user_id BIGINT NOT NULL, "
                + "last_4_digits VARCHAR(4) NOT NULL"
                + ")";
        jdbcTemplate.execute(createTableSql);

        // SQL statement to insert data into the new table
        String insertDataSql = "INSERT INTO " + tableName + " (user_id, last_4_digits) VALUES (?, ?)";
        jdbcTemplate.update(insertDataSql, userId, last4Digits);

        // Return the generated userId
        return userId;
    }
}
